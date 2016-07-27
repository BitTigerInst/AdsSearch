package com.bittiger.AdsSearch.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bittiger.AdsSearch.common.BaseTest;
import com.bittiger.AdsSearch.model.User;
import com.bittiger.AdsSearch.service.UserService;

public class UserServiceTest extends BaseTest {
    @Autowired
    UserService userService;
    
    @Test
    public void testFindAll() {
        try {
            userService.findAllUsers();
            assertTrue(true);
        } catch (Exception e) {
            assertFalse(true);
        }
    }
    
    @Test
    public void testCreatingWithoutUsernameIsForbidden() {
        User newUser = new User();
        
        try {
            userService.createUser(newUser);
            assertFalse(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
    
    @Test
    @Rollback(true)
    public void testCreate() {
        List<User> currentUsers = userService.findAllUsers();
        
        int preNum = currentUsers != null ? currentUsers.size() : 0;
        
        User newUser = new User("MichaelOwen", "1234");
        userService.createUser(newUser);
        
        assertEquals(userService.findAllUsers().size() - preNum, 1);
        assertEquals(userService.findUserByUsername("MichaelOwen").getPassword(), "1234");
    }


}
