package com.bittiger.AdsSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.repository.AdDao;

@Service
public class CounterService {

    @Autowired
    private AdDao adDao;
    
    public Long getNextAdSequence() {
        return this.getNextSequence("ad");
    }
    
    private Long getNextSequence(String collectionName) {
       return adDao.incrementSeq(collectionName);
    }
}
