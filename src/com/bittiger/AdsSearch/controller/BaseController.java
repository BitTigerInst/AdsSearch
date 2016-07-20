package com.bittiger.AdsSearch.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    @RequestMapping(value = "/")
    public String getIndex() {
        service.createPerson();
        return "index";
    }
}
