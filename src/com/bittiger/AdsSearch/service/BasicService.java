package com.bittiger.AdsSearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.User;
import com.bittiger.AdsSearch.repository.CustomerDao;

@Service
public class BasicService {
    @Autowired
    private CustomerDao dao;
    
    public void createPerson() {
        User user = new User();
        user.setUsername("SHIYAO");
        
        dao.create(user);
    }
}
