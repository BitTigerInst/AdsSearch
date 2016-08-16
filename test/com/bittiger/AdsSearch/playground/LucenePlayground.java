package com.bittiger.AdsSearch.playground;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;
import org.tartarus.snowball.ext.PorterStemmer;

public class LucenePlayground {

    public static void main(String []args) {
        AttributeFactory factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;
        //  Lucene 5.x
        StandardTokenizer tokenizer = new StandardTokenizer(factory);
        tokenizer.setReader(new StringReader("Nike Shoes"));
        try {
            tokenizer.reset();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        CharTermAttribute attr = tokenizer.addAttribute(CharTermAttribute.class);
        try {
            
            PorterStemmer stemmer = new PorterStemmer();
            while(tokenizer.incrementToken()) {
                stemmer.setCurrent(attr.toString().toLowerCase());
                stemmer.stem();
                String term = attr.toString();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
