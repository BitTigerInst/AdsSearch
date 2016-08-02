package com.bittiger.AdsSearch.utils;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class AjaxResponseBody {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    
    /**
     * The type refers to whether the response is successful or not.
     * @param type
     */
    public AjaxResponseBody(String type) {
      this.data = new HashMap<String, Object>();
      this.type = type;
    }

    @JsonView(Views.Public.class)
    private String message;
    
    @JsonView(Views.Public.class)
    private String error;
    
    @JsonView(Views.Public.class)
    private HashMap<String, Object> data;
    
    private final String type;
    
    public void putData(String paramName, Object param) {
        this.data.put(paramName, param);
    }
    
    public Object getParam(String paramName) {
        return this.data.get(paramName);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getType() {
        return type;
    }
    
    
}
