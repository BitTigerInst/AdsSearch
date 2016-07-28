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
import com.bittiger.AdsSearch.repository.UserDao;

@Service("daoLoginService")
public class DaoLoginService implements UserDetailsService {
    
    @Autowired
    UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (StringUtils.isBlank(username)) {
//            throw new UsernameNotFoundException("No valid username provided");
//        }
//        
//        User user = userDao.retrievePersonByUserName(username, false);
//        
//        if (person == null) {
//            throw new UsernameNotFoundException("Username doesn't exist");
//        }
//        
//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority> ();
//        UserRole role = new UserRole("ROLE_" + person.getAccountType());
//        
//        authorities.add(role);
//        
//        UserInfo ui = new UserInfo(user.getUsername(), 
//                person.getPassword(), 
//                person.getId(), 
//                authorities);
//        
//        return ui;
        return null;
    }

}
