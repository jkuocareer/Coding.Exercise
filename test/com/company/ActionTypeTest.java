package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActionTypeTest {

    ActionType at = null;

    @Before
    public void setUp() throws Exception {
        //Add Lisa 5454545454545454 $3000
        at = new ActionType("Add", "Lisa", "5454545454545454", 3000f);
    }

    @After
    public void tearDown() throws Exception {

        at = null;
    }

    @Test
    public void getCommand() throws Exception {

        Assert.assertTrue(at.getCommand() > 0);
        Assert.assertSame(ActionType.ADD_COMMAND_OP, at.getCommand());

    }

    @Test
    public void getName() throws Exception {

        Assert.assertNotNull(at.getName());
        Assert.assertSame("Lisa", "Lisa");
    }

    @Test
    public void getAmout() throws Exception {

        Assert.assertEquals(3000.0, at.getAmout(), 0);


    }

    @Test
    public void setAmout() throws Exception {

        at.setAmout(1500);
        Assert.assertEquals(1500.0, at.getAmout(), 0);

    }

    @Test
    public void getCreditCardNumber() throws Exception {

        Assert.assertSame("5454545454545454", at.getCreditCardNumber());

    }

    @Test
    public void setCreditCardNumber() throws Exception {

        at.setCreditCardNumber("4111111111111111");
        Assert.assertSame("4111111111111111", at.getCreditCardNumber());

    }

}