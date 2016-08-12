package com.bittiger.AdsSearch.utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {
    
    public static int randomIndex(int sizeOfCollection) {
        return new Random().nextInt(sizeOfCollection);
    }
    
    /**
     * Generate a random number as a length between minLength and maxLength
     * @param minLength
     * @param maxLength
     * @return
     */
    public static int generateLength(int minLength, int maxLength) {
        return new Random().nextInt(maxLength - minLength + 1) + minLength;
    }
    
    /**
     * Generate a random string with given length
     * @param length
     * @return
     */
    public static  String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
    
    public static String generateRandomString(int minLength, int maxLength) {
        return generateRandomString(generateLength(minLength, maxLength));
    }
    
    public static double generateRandomPrice() {
        return (Math.random() * 5000);
    }
    
    public static String generateRandomStringWithOtherString(String s) {
        return s + " " + RandomUtils.generateRandomString(generateLength(10, 20));
    }
}
