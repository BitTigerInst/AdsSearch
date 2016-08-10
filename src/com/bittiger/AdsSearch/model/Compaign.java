package com.bittiger.AdsSearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="compaign")
public class Compaign {
    @Id
    private String id;
    
    private String compaignName;
    
    public Compaign() {};
    
    public Compaign(String compaignName) {
        this.compaignName = compaignName;
    }

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
