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

import com.bittiger.AdsSearch.service.DaoLoginService;
import com.bittiger.AdsSearch.service.IndexInverter;
import com.bittiger.AdsSearch.service.generators.AdsGenerator;
import com.bittiger.AdsSearch.service.parser.TokensPool;
import com.bittiger.AdsSearch.utils.AjaxResponseBody;


@Controller
public class MainController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private DaoLoginService loginService;

    @Autowired
    AdsGenerator adsGenerator;
    
    @Autowired
    TokensPool tokensPool;
    
    @Autowired
    IndexInverter indexInverter;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
    
    @RequestMapping(value = "/guesswhat", method=RequestMethod.GET)
    public String getBlackTechPage() {
        return "black-technology";
    }
 
    @RequestMapping(value = "/generateAds", method=RequestMethod.POST)
    public @ResponseBody AjaxResponseBody generateAds(@RequestParam(value="number") String number) {
       try {
        tokensPool.initialize();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        return new AjaxResponseBody(AjaxResponseBody.ERROR);
    }
       adsGenerator.createNAds(Integer.parseInt(number));
       adsGenerator.synchronize();
       return new AjaxResponseBody(AjaxResponseBody.SUCCESS);
    }
    
    @RequestMapping(value = "/refreshCache", method=RequestMethod.GET)
    public @ResponseBody AjaxResponseBody refreshCache() {
        indexInverter.refresh();
        
        return new AjaxResponseBody(AjaxResponseBody.SUCCESS);
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
