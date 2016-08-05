package com.bittiger.AdsSearch.service.generators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CompanyGenerator extends FakeDataGenerator {
    public static final int COMPANY_NAME_MIN_LENGTH = 4;
    public static final int COMPANY_NAME_MAX_LENGTH = 10;
    
    
    public List<String> generateNCompanies(int n) {
        List<String> companies = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            companies.add(this.generateOneCompany());
        }
        
        return companies;
    }
    
    public String generateOneCompany() {
        return this.generateRandomString(COMPANY_NAME_MIN_LENGTH, COMPANY_NAME_MAX_LENGTH);
    }
    
}
