package com.bittiger.AdsSearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inverted_index")
public class InvertedIndex {
    @Id
    private String id;
}
