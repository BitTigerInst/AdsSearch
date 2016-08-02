package com.bittiger.AdsSearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bittiger.AdsSearch.utils.AjaxResponseBody;

@Controller
public class SearchController {
    
    @RequestMapping(value="/search")
    public @ResponseBody AjaxResponseBody searchAds(@RequestParam(value="tokens") String tokens) {
        AjaxResponseBody response = new AjaxResponseBody(AjaxResponseBody.SUCCESS);
        
        response.putData("tokens", tokens);
        return response;
    }
    
}
