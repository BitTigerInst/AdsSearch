package com.bittiger.AdsSearch.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.bean.AdBean;
import com.bittiger.AdsSearch.model.Ad;

@Service
public class RedisService {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Resource(name="redisTemplate")
    private SetOperations<String, String> tokenAds;
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String, Object> adsOp;

    public void addAdIdToTokenSet(String loweredToken, String adId) {
        tokenAds.add(loweredToken, adId);
    }
    
    private static final String AD_PREFIX = "AD-";
    private static final String AD_ID = "adId";
    private static final String CONTENT = "content";
    private static final String URL = "url";
    private static final String TOKENS = "Tokens";
    private static final String P_CLICK = "pClick";
    private static final String BID = "bid";
    
    public Set<String> searchAdsForToken(String token) {
        return tokenAds.members(token);
    }
    
    public AdBean searchAdById(String adId) {
        String adKey = AD_PREFIX + adId;
        if (adsOp.hasKey(adKey, AD_ID) != null) {
            AdBean ad = new AdBean();
            ad.setAdId(adId);
            ad.setContent((String) adsOp.get(adKey, CONTENT));
            ad.setTokens((List<String>) adsOp.get(adKey, TOKENS));
            ad.setUrl((String) adsOp.get(adKey, URL));
            ad.setProbClick((double) (adsOp.get(adKey, P_CLICK)));
            ad.setBid((int) adsOp.get(adKey, BID));
            return ad;
        } else {
            return null;
        }
    }
    
    public void addAd(Ad ad) {
        String adKey = AD_PREFIX + ad.getAdId();
        adsOp.put(adKey, AD_ID, ad.getAdId().toString());
        adsOp.put(adKey, CONTENT, ad.getContent());
        adsOp.put(adKey, URL, ad.getUrl());
        adsOp.put(adKey, TOKENS, ad.getTokens());
        adsOp.put(adKey, P_CLICK, ad.getProbClick());
        adsOp.put(adKey, BID, ad.getBid());
    }
    
    public void flushAll() {
        redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                        System.out.println("beforeSize:" + redisConnection.dbSize());
                        redisConnection.flushAll();
                        System.out.println("afterSize:" + redisConnection.dbSize());
                        return null;
                }
        });
    }
}
