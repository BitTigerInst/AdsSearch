package com.bittiger.AdsSearch.bean;

import java.util.List;

import com.bittiger.AdsSearch.model.Ad;

public class AdBean {
    private String adId;
    
    private List<String> tokens;
    
    private double rankScore;
    
    private double relevanceScore;
    
    private double qualityScore;
    
    private double probClick;

    private int bid;
    
    private String content;
    
    private String url;
    
    public AdBean() {
        
    }
    
    public AdBean(Ad ad) {
        this.adId = ad.getAdId().toString();
        this.bid = ad.getBid();
        this.content = ad.getContent();
        this.tokens = ad.getTokens();
        this.url = ad.getUrl();
    }
    
    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }
    
    public double getProbClick() {
        return probClick;
    }
    
    public void setProbClick(double probClick) {
        this.probClick = probClick;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

}
