package com.bittiger.AdsSearch.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.User;

@Repository
public class UserDao extends BaseDao{
    
    private static final String USERNAME = "username";

    public void createUser(User newUser) {
        template.insert(newUser);
    }
    
    public User findUserByUsername(String username) {
        Query query = new Query(Criteria.where(USERNAME).is(username));
        return (User) template.findOne(query, User.class);
    }
    
    public List<User> findAllUsers() {
        return template.findAll(User.class);
    }
    
}
