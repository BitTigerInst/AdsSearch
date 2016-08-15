package com.bittiger.AdsSearch.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;
import org.springframework.stereotype.Service;
import org.tartarus.snowball.ext.PorterStemmer;

@Service
public final class Tokenizer {
    private AttributeFactory factory;
    private StandardTokenizer tokenizer;
    private PorterStemmer stemmer;
    
    public Tokenizer() {
        this.factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;
        this.tokenizer = new StandardTokenizer(factory);
        this.stemmer = new PorterStemmer();
    }
    
    //TODO A elegant solution for concurrency need to be implemented rather than 
    //Simply using synchronized.
    public synchronized List<String> tokenize(String text) throws IOException {
        List<String> tokens = new ArrayList<>();
        if (StringUtils.isBlank(text)) return tokens;
        
        this.tokenizer.setReader(new StringReader(text));
        tokenizer.reset();
        
        CharTermAttribute attr = tokenizer.addAttribute(CharTermAttribute.class);
        while (tokenizer.incrementToken()) {
            stemmer.setCurrent(attr.toString().toLowerCase());
            stemmer.stem();
            tokens.add(stemmer.getCurrent());
        }
        
        return tokens;
    }
    
}
