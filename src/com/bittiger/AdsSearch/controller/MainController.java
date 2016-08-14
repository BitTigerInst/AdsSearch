package com.bittiger.AdsSearch.controller;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bittiger.AdsSearch.service.BasicService;
import com.bittiger.AdsSearch.service.DaoLoginService;
import com.bittiger.AdsSearch.service.generators.AdsGenerator;
import com.bittiger.AdsSearch.service.parser.TokensPool;
import com.bittiger.AdsSearch.utils.AjaxResponseBody;


@Controller
public class MainController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);
    
    @Autowired
    private BasicService service;

    @Autowired
    private DaoLoginService loginService;

    @Autowired
    AdsGenerator adsGenerator;
    
    @Autowired
    TokensPool tokensPool;
    
    @RequestMapping(value = "/createAd", method=RequestMethod.GET)
    public String saveData() {
//        service.createFakeAd();
        
        return "index";
    }
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
    
    @RequestMapping(value = "/guesswhat", method=RequestMethod.GET)
    public String getBlackTechPage() {
        return "black-technology";
    }
    
    @RequestMapping(value = "/processAdsGenerator", method=RequestMethod.GET)
    public String processAdsGenerator() {
        
        return null;
        
    }
 
    @RequestMapping(value = "/generateAds", method=RequestMethod.GET)
    public String generateAds() {
       try {
        tokensPool.initialize();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       adsGenerator.createNAds(100);
       adsGenerator.synchronize();
       return "index";
    }
    
    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public @ResponseBody AjaxResponseBody login(@RequestParam(value="username") String username,
            @RequestParam(value="password") String password) {
            
        UserDetails ui = loginService.loadUserByUsername(username);
        
        if (ui.getPassword() != password) {
            return new AjaxResponseBody(AjaxResponseBody.ERROR);
        } else {
            return new AjaxResponseBody(AjaxResponseBody.SUCCESS);
        }
    }
}
