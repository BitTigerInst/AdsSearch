package com.bittiger.AdsSearch.service.generators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.utils.MathUtils;

@Service
public class CompanyGenerator extends FakeDataGenerator {
    public static final int COMPANY_NAME_MIN_LENGTH = 2;
    public static final int COMPANY_NAME_MAX_LENGTH = 8;
    
    public static final String[] COMPANY_NAME_SUFFIXES = 
            new String[] {"Company", "Co", "Inc", "Group"};
    public static final String[] COMPANY_NAME_PREFIXES = 
            new String[] {"Smart", "Super", "Pretty", "Top", "Beautiful",
                        "Geck", "NewStorm", "Large", "Mil", "Micro", "Universe",
                        "Ubi", "EA-"};
    
    public List<String> generateNCompanies(List<String> keywords) {
        List<String> companies = new ArrayList<>();
        
        for (int i = 0; i < keywords.size(); i++) {
            companies.add(this.generateOneCompany(keywords.get(i)));
        }
        
        return companies;
    }
    
    public String generateOneCompany(String keyword) {
        StringBuilder builder = new StringBuilder();
        String middle = generateRandomString(COMPANY_NAME_MIN_LENGTH, COMPANY_NAME_MAX_LENGTH);
        String prefix = CompanyGenerator.
                COMPANY_NAME_PREFIXES[MathUtils.randomIndex(COMPANY_NAME_PREFIXES.length)];
        String suffix = CompanyGenerator.
                COMPANY_NAME_SUFFIXES[MathUtils.randomIndex(COMPANY_NAME_SUFFIXES.length)];
        
        builder.append(prefix);
        builder.append(" ");
        builder.append(keyword);
        builder.append(" ");
        builder.append(middle);
        builder.append(" ");
        builder.append(suffix);
        
        return builder.toString();
    }
    
}
