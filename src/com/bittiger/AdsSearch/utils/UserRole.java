package com.bittiger.AdsSearch.utils;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority{
    private static final long serialVersionUID = -229315167578422777L;
    
    private String name;
    
    public UserRole() {};
    
    public UserRole(String accountType) {
        this.name = accountType;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }

}