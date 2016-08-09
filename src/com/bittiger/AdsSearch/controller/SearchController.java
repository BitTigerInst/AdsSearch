package com.bittiger.AdsSearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bittiger.AdsSearch.model.Ad;
import com.bittiger.AdsSearch.utils.AjaxResponseBody;


@Controller
public class SearchController {
    
    @RequestMapping(value="/search")
    public @ResponseBody AjaxResponseBody searchAds(@RequestParam(value="searchText") String searchText) {
        AjaxResponseBody response = new AjaxResponseBody(AjaxResponseBody.SUCCESS);
        
        Ad ad1 = new Ad();
        ad1.setContent("Cap One is your best choice!");
        ad1.setCompanyName("Cap One inc");
        ad1.setTitle("Cap One");
        
        Ad ad2 = new Ad();        
        ad2.setContent("Cap Two is your best choice!");
        ad2.setCompanyName("Cap Two inc");
        ad2.setTitle("Cap Two");
        
        List<Ad> ads = new ArrayList<>();
        ads.add(ad1);
        ads.add(ad2);
        
        response.putData("ads", ads);
        return response;
    }
    
}
