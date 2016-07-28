package com.bittiger.AdsSearch.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.model.User;
import com.bittiger.AdsSearch.repository.UserDao;
import com.bittiger.AdsSearch.utils.MongoDaoException;

@Service
public class UserService {

    @Autowired 
    UserDao userDao;
    
    public void createUser(User newUser) {
        if (StringUtils.isBlank(newUser.getUsername()) || StringUtils.isBlank(newUser.getPassword())) {
            throw new MongoDaoException("User fields missing");
        }
        
        User userWithSameUsername = userDao.findUserByUsername(newUser.getUsername());
        if (userWithSameUsername != null) {
            throw new MongoDaoException("Username found duplicated");
        }

        userDao.createUser(newUser);
    }
    
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
    
    public void deleteUserByUsername(String username) {
        userDao.deleteUserByUsername(username);
    }
    
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
