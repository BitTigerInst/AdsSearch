package com.bittiger.AdsSearch.utils;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


public class UserInfo extends User {
    private static final long serialVersionUID = 1192091401956296780L;
    private String userId;
    private String username;
    private Collection <UserRole> authorities;

    @SuppressWarnings("unchecked")
    public UserInfo(String username, String password, String userId, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        // TODO Auto-generated constructor stub
        this.username = username;
        this.userId = userId;
        this.authorities = (Collection<UserRole>) authorities;
    }
    
    public boolean isAuthenticated() {
        if (this.authorities == null || this.authorities.isEmpty()) {
            return false;
        } else {
           for (UserRole role : authorities) {
               if (StringUtils.isNotBlank(role.getAuthority())) {
                   return true;
               }
           }
        }
            
        return true;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
