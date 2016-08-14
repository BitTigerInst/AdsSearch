package com.bittiger.AdsSearch.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bittiger.AdsSearch.model.AnonymouseUser;

@Document(collection = "user")
public class User extends AnonymouseUser {
    @Id
    private String id;

    @Indexed(unique = true)
    
    /* auth info */
    @NotEmpty
    String username;
    @NotEmpty
    String password; /* this should inheritate form auth user */
    				/* auth_user is one to one map to User(ads)*/

    /* User info */
    String gender;
    Integer age;
    Date register_tm; /* historical info */
    Date last_search_time; /* updated historical info */
    
    /* constructor  */
    public User () {}
    
    public User(String username, String password, 
    			String ip,
    			String loc,
    			String browser_agent) {
    	super(ip, browser_agent, loc);
    	
        this.username = username;
        this.password = password;
    }
    
    /* repr */
    public String toString() {
    	return String.format("<User %s {ip is :%s, in loc: %s, using browser agent with: %s}",
    						this.username,
    						this.ip,
    						this.loc,
    						this.browser_agent);
    }
  

    /* setter, getter */
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
    	this.age = age;
    }
    
}