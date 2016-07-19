package com.bittiger.AdsSearch.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
    
    @RequestMapping(value = "/home")
    public String getHome() {
        logger.info("Hit controler");
        return "home";
    }
    
    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }
}
