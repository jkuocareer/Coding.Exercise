package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicAccountTest {

    BasicAccount ba = null;

    @Before
    public void setUp() throws Exception {

        //Add Lisa 5454545454545454 $3000

        ba = new BasicAccount("Lisa", "Lisa", "5454545454545454", 3000d);
    }

    @After
    public void tearDown() throws Exception {

        ba = null;
    }

    @Test
    public void main() throws Exception {
    }

    @Test
    public void getAccountBalance() throws Exception {

        Assert.assertEquals(ba.getAccountBalance(), 0d, 0);

    }


    @Test
    public void getCreditLine() throws Exception {

        Assert.assertEquals(ba.getCreditLine(), 3000d, 0);

    }

    @Test
    public void getAccountNumber() throws Exception {

        Assert.assertSame(ba.getAccountNumber(), "5454545454545454");

    }

    @Test
    public void getAccountNumberLastFourDigits() throws Exception {

        Assert.assertEquals(ba.getAccountNumberLastFourDigits(), "5454");

    }

    @Test
    public void getFirstName() throws Exception {

        Assert.assertSame(ba.getFirstName(), "Lisa");

    }

    @Test
    public void getLastName() throws Exception {

        Assert.assertSame(ba.getLastName(), "Lisa");

    }

    @Test
    public void addBalance() throws Exception {

        ba.addBalance(1d);
        Assert.assertEquals(ba.getAccountBalance(), 1d, 0);


    }

}