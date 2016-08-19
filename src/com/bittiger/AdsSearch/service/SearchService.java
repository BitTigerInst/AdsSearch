package com.bittiger.AdsSearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.Ad;

@Service
public class SearchService {
    
    @Autowired
    IndexInverter indexInverter;
    
    @Autowired
    AdScoreCalculator calculator;
    
    @Autowired
    Tokenizer tokenizer;
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SearchService.class);

    public List<Ad> search(String searchText) {
        List<Ad> ads = new ArrayList<>();
        
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
        List<Ad> pagedAds = ads.stream()
            .map(ad -> {
                ad.setRankScore(calculator.calculateRankScore(finalTokens, ad));
                return ad;
            })
            .sorted((a1, a2) -> {
                return -1 * Double.compare(a1.getRankScore(), a2.getRankScore());
            })
            .limit(10)
            .collect(Collectors.toList());
            
        return pagedAds;
    }

}
