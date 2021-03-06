package com.bittiger.AdsSearch.service.generators;



import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.Ad;
import com.bittiger.AdsSearch.repository.AdDao;
import com.bittiger.AdsSearch.service.parser.TokensPool;
import com.bittiger.AdsSearch.utils.RandomUtils;

@Service
public class AdsGenerator {
    
    @Autowired
    TokensPool pool;
    
    @Autowired
    AdDao adDao;
    
    private Set<Ad> adsSet = new HashSet<>();
    
    public void synchronize() {
        for (Ad ad : adsSet) {
            adDao.createAd(ad);
        }
        
        try {
            pool.initialize();
        } catch (IOException e) {
        }
    }
    
    public void createNAds(int n) {
        for (int i = 0; i < n; i++) {
            adsSet.add(this.generateOneAd());
        }
    }
    
    private Ad generateOneAd() {
        Ad ad = new Ad();
        
        ad.setBid(RandomUtils.generateRandomPrice());
        ad.setCompaignId(UUID.randomUUID().toString());
        
        List<String> keywords = pool.grepKeywords();
        ad.setProbClick(Math.random());
        ad.setTokens(keywords);
        ad.setContent(RandomUtils.generateRandomStringWithOtherString(keywords.toString()));
        return ad;
    }
    

}
