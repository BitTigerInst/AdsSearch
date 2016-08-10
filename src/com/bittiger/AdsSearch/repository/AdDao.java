package com.bittiger.AdsSearch.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.Ad;
import com.bittiger.AdsSearch.model.Compaign;
import com.bittiger.AdsSearch.model.Company;

@Repository
public class AdDao extends BaseDao{
    private static final String ID = "id";
    
    public void createAd(Ad newad) {
        template.insert(newad);
    }
    
    public void createCompany(Company company) {
        template.insert(company);
    }
    
    public void createCompaign(Compaign compaign) {
        template.insert(compaign);
    }
    
    public Ad findAdById(String id) {
        Query query = new Query(Criteria.where(ID).is(id));
        return (Ad) template.findOne(query, Ad.class);
    }
    
    public List<Ad> findAllAds() {
        return template.findAll(Ad.class);
    }
    
    public void deleteAd(Ad ad) {
        template.remove(ad);
    }
    
    public void deleteUserById(String id) {
        Query query = new Query(Criteria.where(ID).is(id));
        template.remove(query, Ad.class);
    }    
}
