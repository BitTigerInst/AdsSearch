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

import com.bittiger.AdsSearch.config.AppProps;

public class TokensPool {
    private AppProps props;
    
    private static final Logger logger = LoggerFactory.getLogger(TokensPool.class);    

    private HashMap<String, HashSet<String>> keywordsPool;
    
    private static TokensPool instance;

    public static TokensPool getInstance() {
        if (instance == null) {
            instance = new TokensPool();
            instance.props = new AppProps();
            instance.keywordsPool = new HashMap<>();
        }
        
        return instance;
    }
    
    private TokensPool() {}
    
    public HashMap<String, HashSet<String>> getPool() {
        return instance.keywordsPool;
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
        
        String groupName = strs[0];
        this.keywordsPool.put(groupName, new HashSet<String>());
        
        for (int i = 1; i < strs.length; i++) {
            String[] words = strs[i].replaceAll("^[,\\s]+", "").split("[,\\s]+");
            for (String word: words) {
                this.keywordsPool.get(groupName).add(word);
            }
        }
    }
    
    public static void main(String []args) throws IOException {
        TokensPool parser = TokensPool.getInstance();
        parser.parse();
    }
}
