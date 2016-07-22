package com.bittiger.AdsSearch.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.SimpleAd;

@Repository
public class SimpleAdDao {
    @Autowired
    private MongoTemplate template;
    
    public void createAd(SimpleAd ad) {
        template.save(ad);
    }
    
    public List<SimpleAd> retrieveAllAds() {
        return template.findAll(SimpleAd.class);
    }
}
