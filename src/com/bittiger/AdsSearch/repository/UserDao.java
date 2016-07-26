package com.bittiger.AdsSearch.repository;

import org.springframework.stereotype.Repository;

import com.bittiger.AdsSearch.model.User;

@Repository
public class UserDao extends BaseDao{

    public void createUser(User newUser) {
        template.insert(newUser);
    }
    
//    public User findByUsername(String username) {
//    }
}
