package com.bittiger.AdsSearch.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.bean.AdBean;
import com.bittiger.AdsSearch.model.Ad;
import com.bittiger.AdsSearch.repository.AdDao;

@Service
public class IndexInverter {
    
    @Autowired
    private AdDao adDao;
    
    @Autowired
    private RedisService redisService;
    
    public IndexInverter() {
    }
    
    public void refresh() {
        redisService.flushAll();
        this.process();
    }
    
    public List<AdBean> searchToken(String token) {
        Set<String> adsIds = redisService.searchAdsForToken(token);
        
        List<AdBean> ads =
               adsIds.stream()
               .map( (id) -> redisService.searchAdById(id))
               .collect(Collectors.toList());
        
        return ads;
    }
    
    public void loadToMap(List<Ad> ads) {
        ads.stream()
            .forEach((ad) -> {
                this.processSingleAd(ad);
            }); 
    }
    
    @PostConstruct
    public void process() {
        List<Ad> allAds = adDao.findAllAds();
        allAds.stream()
            .forEach((ad) -> redisService.addAd(ad));
        this.loadToMap(allAds);
    }
    
    private void processSingleAd(Ad ad) {
        ad.getTokens()
            .stream()
            .map(token -> token.toLowerCase())
            .forEach(loweredToken -> {
                redisService.addAdIdToTokenSet(loweredToken, ad.getAdId().toString());
            });
    }
}
