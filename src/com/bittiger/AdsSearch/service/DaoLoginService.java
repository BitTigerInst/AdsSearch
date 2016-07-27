package com.bittiger.AdsSearch.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.User;
import com.bittiger.AdsSearch.utils.UserInfo;
import com.bittiger.AdsSearch.utils.UserRole;

@Service("daoLoginService")
public class DaoLoginService implements UserDetailsService {
    
    @Autowired
    UserService userService;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("No valid username provided");
        }
        
        User user = userService.findUserByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Username doesn't exist");
        }
        
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority> ();
        UserRole role = new UserRole("ROLE_USER");
        
        authorities.add(role);
        
        UserInfo ui = new UserInfo(user.getUsername(), user.getPassword(), user.getId(), authorities);
        
        return ui;
    }

}
