package com.bittiger.AdsSearch.playground;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;

public class LucenePlayground {
    
    public static void main(String []args) {
        AttributeFactory factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;
     //  Lucene 5.x
     StandardTokenizer tokenizer = new StandardTokenizer(factory);
     tokenizer.setReader(new StringReader("Tokenizer123! him!"));
     try {
        tokenizer.reset();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

     CharTermAttribute attr = tokenizer.addAttribute(CharTermAttribute.class);
     try {
        while(tokenizer.incrementToken()) {
             String term = attr.toString();
             System.out.println(term);
         }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

}
