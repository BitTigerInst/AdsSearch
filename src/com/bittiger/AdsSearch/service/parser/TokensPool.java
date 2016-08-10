package com.bittiger.AdsSearch.service.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bittiger.AdsSearch.config.AppProps;
import com.bittiger.AdsSearch.model.Compaign;
import com.bittiger.AdsSearch.repository.AdDao;

@Service
public class TokensPool {
    
    @Autowired
    private AppProps props;
    
    @Autowired
    private AdDao adDao;
    
    private static final Logger logger = LoggerFactory.getLogger(TokensPool.class);    

    private HashMap<String, HashSet<String>> keywordsPool;
    
    public TokensPool() {
        keywordsPool = new HashMap<>();
    }
    
    public HashMap<String, HashSet<String>> parse() throws IOException {
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
        
        String compaignName = strs[0];
        if (!this.keywordsPool.containsKey(compaignName)) {
            this.keywordsPool.put(compaignName, new HashSet<String>());
            adDao.createCompaign(new Compaign(compaignName));
        }

        
        for (int i = 1; i < strs.length; i++) {
            String[] words = strs[i].replaceAll("^[,\\s]+", "").split("[,\\s]+");
            for (String word: words) {
                if (!this.keywordsPool.get(compaignName).contains(word)) {
                    this.keywordsPool.get(compaignName).add(word);
                }
            }
        }
    }

}
