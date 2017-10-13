package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LuhnAlgorithmTest {

    final String validCCNumber = "4847352989263094";
    final String invalidCCNumber = "1234567890123456";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isAValidCard() throws Exception {


        Assert.assertTrue(LuhnAlgorithm.isAValidCard(validCCNumber));
        Assert.assertFalse(LuhnAlgorithm.isAValidCard(invalidCCNumber));

    }

    @Test
    public void isAValidCardSpeed() throws Exception {

        Assert.assertTrue(LuhnAlgorithm.isAValidCard(validCCNumber));

    }


}