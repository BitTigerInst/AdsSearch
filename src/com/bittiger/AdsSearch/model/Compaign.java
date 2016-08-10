package com.bittiger.AdsSearch.model;

import org.springframework.data.annotation.Id;

public class Compaign {
    @Id
    private String id;
    
    private String compaignName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompaignName() {
        return compaignName;
    }

    public void setCompaignName(String compaignName) {
        this.compaignName = compaignName;
    }
    
    
}
