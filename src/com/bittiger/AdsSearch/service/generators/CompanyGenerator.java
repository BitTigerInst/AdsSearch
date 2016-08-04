package com.bittiger.AdsSearch.service.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class CompanyGenerator {
    public static final int MIN_LENGTH = 4;
    public static final int MAX_LENGTH = 10;
    
    
    public List<String> generateNCompanies(int n) {
        List<String> companies = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            companies.add(this.generateOneCompany());
        }
        
        return companies;
    }
    
    public String generateOneCompany() {
        int length = this.generateLength();
        
        return RandomStringUtils.random(length);
    }
    
    private int generateLength() {
        return new Random().nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
    }
}
