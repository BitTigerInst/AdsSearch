package com.bittiger.AdsSearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="counter")
public class Counter {
    public static String DOCUMENT_NAME = "document_name";
    public static String DOCUMENT_AD = "ad_counter";
    
    @Id
    private String id;
    
    private String document_name;
    
    private Long seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }
    
}
