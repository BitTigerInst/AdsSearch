package com.bittiger.AdsSearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping(value = "/home")
    public String getHome() {
        return "home";
    }
    
    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }
}
