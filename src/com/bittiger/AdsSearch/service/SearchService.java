package com.bittiger.AdsSearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.Ad;

@Service
public class SearchService {
    
    @Autowired
    IndexInverter indexInverter;
    
    @Autowired
    Tokenizer tokenizer;
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SearchService.class);

    public List<Ad> search(String searchText) {
        List<Ad> ads = new ArrayList<>();
        
        List<String> tokens = null;
        try {
            tokens = tokenizer.tokenize(searchText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        tokens.stream()
            .map((token) -> {
                return indexInverter.searchToken(token);
            })
            .forEach( list -> ads.addAll(list));
        
        return ads;
    }

}