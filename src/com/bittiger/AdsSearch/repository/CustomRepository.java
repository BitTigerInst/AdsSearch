package com.bittiger.AdsSearch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bittiger.AdsSearch.model.Customer;

public interface CustomRepository extends MongoRepository<Customer, String>{
    public Customer findByFirstName(String firstName);
    
    public List<Customer> findByLastName(String lastName); 
}
