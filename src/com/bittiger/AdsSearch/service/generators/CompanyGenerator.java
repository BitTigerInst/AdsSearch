package com.bittiger.AdsSearch.service.generators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.Company;
import com.bittiger.AdsSearch.utils.RandomUtils;

@Service
public class CompanyGenerator {
    public static final int COMPANY_NAME_MIN_LENGTH = 2;
    public static final int COMPANY_NAME_MAX_LENGTH = 8;
    
    public static final String[] COMPANY_NAME_SUFFIXES = 
            new String[] {"Company", "Co", "Inc", "Group"};
    public static final String[] COMPANY_NAME_PREFIXES = 
            new String[] {"Smart", "Super", "Pretty", "Top", "Beautiful",
                        "Geck", "NewStorm", "Large", "Mil", "Micro", "Universe",
                        "Ubi", "EA-"};
    
    public List<Company> generateNCompanies(int n) {
        List<Company> companies = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            companies.add(this.generateOneCompanyWithoutAd());
        }
        
        return companies;
    }
    
    public Company generateOneCompanyWithoutAd() {
        StringBuilder builder = new StringBuilder();
        String middle = RandomUtils.generateRandomString(COMPANY_NAME_MIN_LENGTH, COMPANY_NAME_MAX_LENGTH);
        String prefix = CompanyGenerator.
                COMPANY_NAME_PREFIXES[RandomUtils.randomIndex(COMPANY_NAME_PREFIXES.length)];
        String suffix = CompanyGenerator.
                COMPANY_NAME_SUFFIXES[RandomUtils.randomIndex(COMPANY_NAME_SUFFIXES.length)];
        
        builder.append(prefix);
        builder.append(" ");
        builder.append(middle);
        builder.append(" ");
        builder.append(suffix);
        
        Company company = new Company();
        company.setCompanyName(builder.toString());
        
        return company;
    }
    
}
