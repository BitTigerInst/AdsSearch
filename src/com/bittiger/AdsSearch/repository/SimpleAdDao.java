package com.bittiger.AdsSearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.SimpleAd;

@Repository
public class SimpleAdDao {
    private static final String COLLECTION_NAME = "SimpleAd";

    @Autowired
    private MongoTemplate template;
    
    public void createAd(SimpleAd ad) {
        template.insert(ad, COLLECTION_NAME);
    }
    
}
