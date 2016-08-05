package com.bittiger.AdsSearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppProps {
    
    @Value("${tokens_location}")
    private String tokensFileLocation;

    public String getTokensFileLocation() {
        return tokensFileLocation;
    }

    public void setTokensFileLocation(String tokensFileLocation) {
        this.tokensFileLocation = tokensFileLocation;
    }
}
