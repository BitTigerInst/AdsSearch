package com.bittiger.AdsSearch.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Resource(name="redisTemplate")
    private SetOperations<String, String> tokenAds;
    
    public void addAdIdToTokenSet(String loweredToken, String adId) {
        tokenAds.add(loweredToken, adId);
    }
}
