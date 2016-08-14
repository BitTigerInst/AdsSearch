package com.bittiger.AdsSearch.service.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.config.AppProps;
import com.bittiger.AdsSearch.model.Compaign;
import com.bittiger.AdsSearch.repository.AdDao;
import com.bittiger.AdsSearch.utils.RandomUtils;

@Service
public class TokensPool {
    
    @Autowired
    private AppProps props;
    
    @Autowired
    private AdDao adDao;
    
    private static final Logger logger = LoggerFactory.getLogger(TokensPool.class);    

    private HashMap<String, HashSet<String>> keywordsPool;
    private List<String> groupList;
    
    public TokensPool() {
        this.keywordsPool = new HashMap<>();
        this.groupList = new ArrayList<>();
    }
    
    public List<String> grepKeywords() {
        int groupIndex = RandomUtils.randomIndex(groupList.size());
        List<String> keywords = new ArrayList<>();
        
        String groupName = groupList.get(groupIndex);
        
        keywords.addAll(keywordsPool.get(groupName));
        
        Collections.shuffle(keywords);
        
        int length = RandomUtils.generateLength(0, keywords.size());
        
        keywords = keywords.stream()
                    .limit(length)
                    .collect(Collectors.toList());
        
        return keywords;
        
    }
    
    @PostConstruct
    public HashMap<String, HashSet<String>> initialize() throws IOException {
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(props.getTokensFileLocation()));
            String line;
            
            while((line = reader.readLine()) != null) {
                this.processLine(line);
            }
            
            System.out.println(this.keywordsPool.toString());
            
            return keywordsPool;
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error(e.getMessage());
            return null;
        } finally {
            reader.close();
        }
    }
    
    private void processLine(String line) {
        String[] strs = line.split("[:]");
        
        String groupName = strs[0];
        if (!this.keywordsPool.containsKey(groupName)) {
            this.keywordsPool.put(groupName, new HashSet<String>());
            this.groupList.add(groupName);
            adDao.createCompaign(new Compaign(groupName));
        }

        
        for (int i = 1; i < strs.length; i++) {
            String[] words = strs[i].replaceAll("^[,\\s]+", "").split("[,\\s]+");
            for (String word: words) {
                if (!this.keywordsPool.get(groupName).contains(word)) {
                    this.keywordsPool.get(groupName).add(word);
                }
            }
        }
    }
    
    

}
