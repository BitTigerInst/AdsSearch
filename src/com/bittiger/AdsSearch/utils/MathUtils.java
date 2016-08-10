package com.bittiger.AdsSearch.utils;

import java.util.Random;

public class MathUtils {
    
    public static int randomIndex(int sizeOfCollection) {
        return new Random().nextInt(sizeOfCollection);
    }
}
