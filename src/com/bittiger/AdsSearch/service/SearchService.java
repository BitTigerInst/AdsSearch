package com.bittiger.AdsSearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.bean.AdBean;

@Service
public class SearchService {
    
    @Autowired
    IndexInverter indexInverter;
    
    @Autowired
    AdScoreCalculator calculator;
    
    @Autowired
    Tokenizer tokenizer;
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SearchService.class);

    public List<AdBean> search(String searchText) {
        List<AdBean> ads = new ArrayList<>();
        
        List<String> tokens = null;
        try {
            tokens = tokenizer.tokenize(searchText);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        
        tokens.stream()
            .map((token) -> {
                return indexInverter.searchToken(token);
            })
            .forEach( list -> ads.addAll(list));
        
        final List<String> finalTokens = tokens;
        List<AdBean> pagedAds = ads.stream()
            .map(bean -> {
                bean.setRelevanceScore(calculator.calculateRelevanceScore(finalTokens, bean));
                bean.setQualityScore(calculator.calculateQualityScore(bean.getRelevanceScore(), bean.getProbClick()));
                bean.setRankScore(calculator.calculateRankScore(bean.getQualityScore(), bean.getBid()));
                
                return bean;
            })
            .filter((bean) -> bean.getRelevanceScore() >= 0.25)
            .sorted((a1, a2) -> {
                return -1 * Double.compare(a1.getRankScore(), a2.getRankScore());
            })
            .limit(20)
            .collect(Collectors.toList());
            
        return pagedAds;
    }

}
