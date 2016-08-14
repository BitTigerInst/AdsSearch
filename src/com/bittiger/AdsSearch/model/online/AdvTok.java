package com.bittiger.AdsSearch.model.online;

import java.math.BigInteger;
import java.util.SortedSet;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class AdvTok {
	@Id
	private BigInteger ad_id;
	
	private SortedSet<Integer> url_token_ids; /*parsed from url*/
	private SortedSet<Integer> purchased_keyword_ids;
	private SortedSet<Integer> title_token_ids;
	private SortedSet<Integer> description_token_ids;
	private SortedSet<Integer> top_tok_near_title; /* nearby in space */
	private SortedSet<Integer> top_tok_near_anchor; /* nearby in space */
	
	/* repr */
	public String toString() {
		return String.format("<AdvTok {%d from url, %d from purchased keywords, %d from title, %d from description}>", 
							url_token_ids.size(),
							purchased_keyword_ids.size(),
							title_token_ids.size(),
							description_token_ids.size(),
							top_tok_near_title.size(),
							top_tok_near_anchor);
	}
	
	/* getter & setter */
	public BigInteger getAd_id() {
		return ad_id;
	}
	public void setAd_id(BigInteger ad_id) {
		this.ad_id = ad_id;
	}
	public SortedSet<Integer> getUrl_token_ids() {
		return url_token_ids;
	}
	public void setUrl_token_ids(SortedSet<Integer> url_token_ids) {
		this.url_token_ids = url_token_ids;
	}
	public SortedSet<Integer> getPurchased_keyword_ids() {
		return purchased_keyword_ids;
	}
	public void setPurchased_keyword_ids(SortedSet<Integer> purchased_keyword_ids) {
		this.purchased_keyword_ids = purchased_keyword_ids;
	}
	public SortedSet<Integer> getTitle_token_ids() {
		return title_token_ids;
	}
	public void setTitle_token_ids(SortedSet<Integer> title_token_ids) {
		this.title_token_ids = title_token_ids;
	}
	public SortedSet<Integer> getDescription_token_ids() {
		return description_token_ids;
	}
	public void setDescription_token_ids(SortedSet<Integer> description_token_ids) {
		this.description_token_ids = description_token_ids;
	}
	public SortedSet<Integer> getTop_tok_near_title() {
		return top_tok_near_title;
	}
	public void setTop_tok_near_title(SortedSet<Integer> top_tok_near_title) {
		this.top_tok_near_title = top_tok_near_title;
	}
	public SortedSet<Integer> getTop_tok_near_anchor() {
		return top_tok_near_anchor;
	}
	public void setTop_tok_near_anchor(SortedSet<Integer> top_tok_near_anchor) {
		this.top_tok_near_anchor = top_tok_near_anchor;
	}
	
}
