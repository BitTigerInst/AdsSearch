package com.bittiger.AdsSearch.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bittiger.AdsSearch.model.Ad;
import com.bittiger.AdsSearch.service.IndexInverter;
import com.bittiger.AdsSearch.utils.AjaxResponseBody;


@Controller
public class SearchController {
    
    @Autowired
    IndexInverter indexInverter;
    
    @RequestMapping(value="/search")
    public @ResponseBody AjaxResponseBody searchAds(@RequestParam(value="searchText") String searchText) {
        AjaxResponseBody response = new AjaxResponseBody(AjaxResponseBody.SUCCESS);
        
        Ad ad1 = new Ad();
        ad1.setContent("Cap One is your best choice!");
        ad1.setId(new BigInteger("123123"));
        
        Ad ad2 = new Ad();        
        ad2.setContent("Cap Two is your best choice!");
        ad1.setId(new BigInteger("511122"));
        List<Ad> ads = new ArrayList<>();
        ads.add(ad1);
        ads.add(ad2);
        
        response.putData("ads", ads);
        return response;
    }
    
}
