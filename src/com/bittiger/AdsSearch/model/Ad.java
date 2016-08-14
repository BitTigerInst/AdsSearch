package com.bittiger.AdsSearch.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ad")
public class Ad {
    @Id
    private BigInteger id;
    
    private String advertiser_id;
    private String dispaly_url; /* this will generate a lot of tokens, redundant info*/
    private BigInteger purchased_keys_id;
    private BigInteger title_id;
    private BigInteger description_id;
    private BigInteger rank; /*?*/
    private Date published_tm;
    
    /* getter & setter */
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getAdvertiser_id() {
		return advertiser_id;
	}
	public void setAdvertiser_id(String advertiser_id) {
		this.advertiser_id = advertiser_id;
	}
	public String getDispaly_url() {
		return dispaly_url;
	}
	public void setDispaly_url(String dispaly_url) {
		this.dispaly_url = dispaly_url;
	}
	public BigInteger getPurchased_keys_id() {
		return purchased_keys_id;
	}
	public void setPurchased_keys_id(BigInteger purchased_keys_id) {
		this.purchased_keys_id = purchased_keys_id;
	}
	public BigInteger getTitle_id() {
		return title_id;
	}
	public void setTitle_id(BigInteger title_id) {
		this.title_id = title_id;
	}
	public BigInteger getDescription_id() {
		return description_id;
	}
	public void setDescription_id(BigInteger description_id) {
		this.description_id = description_id;
	}
	public BigInteger getRank() {
		return rank;
	}
	public void setRank(BigInteger rank) {
		this.rank = rank;
	}
	public Date getPublished_tm() {
		return published_tm;
	}
	public void setPublished_tm(Date published_tm) {
		this.published_tm = published_tm;
	}

    
}
