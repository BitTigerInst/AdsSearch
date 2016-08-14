package com.bittiger.AdsSearch.model;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ad")
public class Ad {
    @Id
    private String id;

    private String compaignId;
    
    @NotEmpty
    private List<String> tokens;
    
    @Deprecated
    private String companyId;
    
    private double rankScore;
    
    private double relevanceScore;
    
    private double qualityScore;
    
    private double bid;
    
    private String content;
    
    public String getCompaignId() {
        return compaignId;
    }

    public void setCompaignId(String compaignId) {
        this.compaignId = compaignId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public double getRankScore() {
        return rankScore;
    }

    public void setRankScore(double rankScore) {
        this.rankScore = rankScore;
    }

    public double getRelevanceScore() {
        return relevanceScore;
    }

    public void setRelevanceScore(double relevaceScore) {
        this.relevanceScore = relevaceScore;
    }

    public double getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
