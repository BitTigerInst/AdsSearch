package com.bittiger.AdsSearch.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bittiger.AdsSearch.service.BasicService;


@Controller
public class BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    @Autowired
    private BasicService service;
    
    @RequestMapping(value = "/home")
    public String getHome() {
        logger.info("Hit controler");
       
        return "home";
    }
    
    @RequestMapping(value = "/home2")
    public String getHome2() {
        logger.info("Hit controler2");
        
        return "home";
    }
    
    @RequestMapping(value = "/createAd", method=RequestMethod.GET)
    public String saveData() {
        return "index";
    }
    
    @RequestMapping(value = "/index", method=RequestMethod.GET)
    public String getIndex() {
        return "index";
    }
    
}
