package com.bittiger.AdsSearch.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:com/bittiger/AdsSearch/config/spring-beans.xml",
        "classpath:com/bittiger/AdsSearch/config/mongo-test-config.xml"
    })
public class BaseTest {

    @Before
    public void setup() {
    }

}
