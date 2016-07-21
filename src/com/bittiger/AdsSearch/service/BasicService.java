package com.bittiger.AdsSearch.service;

import java.math.BigInteger;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.SimpleAd;
import com.bittiger.AdsSearch.repository.SimpleAdDao;

@Service
public class BasicService {
    @Autowired
    private SimpleAdDao adDao;
    
    public void createFakeAd() {
        SimpleAd ad = new SimpleAd();
        ad.setCompanyName("Pepsi");
        ad.setKeywords(Arrays.asList("Drink", "food", "sport"));
        ad.setRank(new BigInteger("1"));
        ad.setContent("Come and drink Pepsi!");
        
        adDao.createAd(ad);
    }
}
