package com.bittiger.AdsSearch.service.generators;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class FakeDataGenerator {
    
    /**
     * Generate a random number as a length between minLength and maxLength
     * @param minLength
     * @param maxLength
     * @return
     */
    public int generateLength(int minLength, int maxLength) {
        return new Random().nextInt(maxLength - minLength + 1) + minLength;
    }
    
    /**
     * Generate a random string with given length
     * @param length
     * @return
     */
    public String generateRandomString(int length) {
        return RandomStringUtils.random(length);
    }
    
    public String generateRandomString(int minLength, int maxLength) {
        return this.generateRandomString(this.generateLength(minLength, maxLength));
    }
    
}
