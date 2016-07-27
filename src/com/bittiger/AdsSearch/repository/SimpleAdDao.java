package com.bittiger.AdsSearch.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.SimpleAd;

@Repository
public class SimpleAdDao extends BaseDao {
    
    public void createAd(SimpleAd ad) {
        template.save(ad);
    }
    
    public List<SimpleAd> retrieveAllAds() {
        return template.findAll(SimpleAd.class);
    }
}
