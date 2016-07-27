package com.bittiger.AdsSearch.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.User;

@Repository
public class CustomerDao {
    @Autowired
    private MongoTemplate mongoTemplate;
        
    public void create(User p) {
        System.out.println(this.mongoTemplate == null);
        this.mongoTemplate.insert(p, "customer");
    }
}
