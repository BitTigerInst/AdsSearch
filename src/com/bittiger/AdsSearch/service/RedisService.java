package com.bittiger.AdsSearch.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    
    @Autowired
    private RedisTemplate<String, String> template;
    
    @Resource(name="redisTemplate")
    private SetOperations setOps;
    
    public void test() {
    }
}
