package com.bittiger.AdsSearch.config;

import java.net.UnknownHostException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.bittiger.AdsSearch.model.User;
import com.bittiger.AdsSearch.repository.CustomerDao;
import com.mongodb.MongoClient;

public class MongoDBmain {

	public static void main(String[] args) {


			try {
				MongoClient mongo = new MongoClient(
						"127.0.0.1");
				MongoOperations mongoOps = new MongoTemplate(mongo, "demo");
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
				CustomerDao cd = (CustomerDao) ctx.getBean("CustomerDao");
				User user = new User();
				user.setId("1");
				user.setPassword("p");
				user.setUsername("tt");
				cd.create(user);
				mongo.close();
				System.out.println("d");
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
	}

}
