package com.bittiger.AdsSearch.repository;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.Counter;

@Repository
public class BaseDao {
    @Autowired
    protected MongoTemplate template;
    
    public Long incrementSeq(String collectionName) {
        Counter counter = template.findAndModify(
                new Query(Criteria.where("_id").is(collectionName)), 
                        new Update().inc("seq", 1),
                        FindAndModifyOptions.options().returnNew(true),
                        Counter.class);
        return counter.getSeq();
    }
}
