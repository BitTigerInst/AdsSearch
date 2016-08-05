package com.bittiger.AdsSearch.service.generators;



import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.Ad;

@Service
public class AdsGenerator extends FakeDataGenerator{
    @Autowired
    private CompanyGenerator companyGenerator;
    
    private static final int CONTENT_MIN_LENGTH = 25;
    private static final int CONTENT_MAX_LENGTH = 100;
    
    private static final int TITLE_MIN_LENGTH = 10;
    private static final int TITLE_MAX_LENGTH = 30;
    
    private static final BigInteger DEFAULT_RANK = new BigInteger("0");
    
    public Ad generateOneAd() {
        Ad ad = new Ad();
        ad.setCompanyName(companyGenerator.generateOneCompany());
        ad.setContent(this.generateRandomString(CONTENT_MIN_LENGTH, CONTENT_MAX_LENGTH));
        ad.setRank(DEFAULT_RANK);
        ad.setTitle(this.generateRandomString(TITLE_MIN_LENGTH, TITLE_MAX_LENGTH));
        return ad;
    }

}
