package com.bittiger.AdsSearch.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.bean.AdBean;

@Service
public class AdScoreCalculator {
    private final double PROB_CLICK_WEIGHT = 0.75;
    
    private final double RELEVANCE_SCORE_WEIGHT = 0.25;
   
    /**
     * The tokens should be already processed by lucene.
     * @param tokens
     * @param ad
     * @return
     */
    public double calculateRelevanceScore(List<String> tokens, AdBean ad) {
        int keywordsSize = ad.getTokens().size();
        
        HashSet<String> tokenSet = new HashSet<>(tokens);
        
        double count = 0.0;
        for (String adToken : ad.getTokens()) {
            if (tokenSet.contains(adToken)) count++;
        }
        
        return count / keywordsSize;
    }
    
    
    public double calculateRankScore(List<String> tokens, AdBean ad) {
        return this.calculateRankScore(this.calculateQualityScore(tokens, ad), ad.getBid());
    }
    
    public double calculateRankScore(double qualityScore, int bid) {
        return qualityScore * bid;
    }
    
    public double calculateQualityScore(List<String> tokens, AdBean ad) {
        return this.calculateQualityScore(this.calculateRelevanceScore(tokens, ad), ad.getProbClick());
    }
    
    public double calculateQualityScore(double relevanceScore, double probClick) {
        return this.PROB_CLICK_WEIGHT * probClick + this.RELEVANCE_SCORE_WEIGHT * relevanceScore;
    }
    
}
