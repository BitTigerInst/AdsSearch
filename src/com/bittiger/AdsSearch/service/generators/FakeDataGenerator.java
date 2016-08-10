package com.bittiger.AdsSearch.service.generators;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.service.parser.TokensPool;

@Service
public class FakeDataGenerator {
    @Autowired 
    private TokensPool pool;
    
    public void process() {
        try {
            pool.parse();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}
