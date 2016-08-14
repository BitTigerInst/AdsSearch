package com.bittiger.AdsSearch.model;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class QuerySession {
	@Id
	private String id;
	/* many user to many ads mapping through a query */
	private String user_id;
	private BigInteger ad_id;
	private String query_id;
	/* query feature */
	private List<String> qry_tokens;
	
	/* user session feature */
	private String issued_ip;
	private String issued_browser_agent;
	private String issued_loc;
	private Date query_tm;
	
	/* adv sesssion feature */
	private Integer depth; /* total number ads impressed to the user */
	private Integer position; /* the position of the ad in query result impressed to a user */
	private Integer click; /* used for train data set */
	private Integer impression;
	
	/* repr */
    public String toString() {
    	return String.format("<QuerySession {ad %d triggered by user %s, at pos %d over depth %d at %t}>",
    						this.ad_id,
    						this.user_id,
    						this.position,
    						this.depth,
    						this.query_tm);
    }
	
	/* getter & setter */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public BigInteger getAd_id() {
		return ad_id;
	}
	public void setAd_id(BigInteger ad_id) {
		this.ad_id = ad_id;
	}
	public String getQuery_id() {
		return query_id;
	}
	public void setQuery_id(String query_id) {
		this.query_id = query_id;
	}
	public List<String> getTokens() {
		return qry_tokens;
	}
	public void setTokens(List<String> tokens) {
		this.qry_tokens = tokens;
	}
	public String getIssued_ip() {
		return issued_ip;
	}
	public void setIssued_ip(String issued_ip) {
		this.issued_ip = issued_ip;
	}
	public String getIssued_browser_agent() {
		return issued_browser_agent;
	}
	public void setIssued_browser_agent(String issued_browser_agent) {
		this.issued_browser_agent = issued_browser_agent;
	}
	public String getIssued_loc() {
		return issued_loc;
	}
	public void setIssued_loc(String issued_loc) {
		this.issued_loc = issued_loc;
	}
	public Date getQuery_tm() {
		return query_tm;
	}
	public void setQuery_tm(Date query_tm) {
		this.query_tm = query_tm;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public Integer getImpression() {
		return impression;
	}
	public void setImpression(Integer impression) {
		this.impression = impression;
	}
	
	
}
