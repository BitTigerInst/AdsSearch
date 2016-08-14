package com.bittiger.AdsSearch.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "anonymouse_user")
public class AnonymouseUser {
	
	String ip;
	String browser_agent;
	String loc;

	/* constructor  */
	public AnonymouseUser(){};
	
	public AnonymouseUser(String ip, 
						  String browser_agent,
						  String loc){
		this.ip = ip;
		this.browser_agent = browser_agent;
		this.loc = loc;
		
	}
	
	/* repr */
    public String toString() {
    	return String.format("<Anonymouse User {ip is :%s, in loc: %s, using browser agent with: %s}>",
    						this.ip, this.browser_agent, this.loc);
    }

    /* getter & setter */
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser_agent() {
		return browser_agent;
	}

	public void setBrowser_agent(String browser_agent) {
		this.browser_agent = browser_agent;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
    
}
