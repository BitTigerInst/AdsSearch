package com.bittiger.AdsSearch.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bittiger.AdsSearch.model.Ad;
import com.bittiger.AdsSearch.service.SearchService;
import com.bittiger.AdsSearch.utils.AjaxResponseBody;


@Controller
public class SearchController {    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    SearchService searchService;
    
    @RequestMapping(value="/search")
    public @ResponseBody AjaxResponseBody searchAds(@RequestParam(value="searchText") String searchText) {        
        List<Ad> ads = searchService.search(searchText);
        
        AjaxResponseBody response = new AjaxResponseBody(AjaxResponseBody.SUCCESS);
        response.putData("ads", ads);
        return response;
    }
    
}
