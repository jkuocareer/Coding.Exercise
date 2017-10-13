package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransactionProcessorTest {

    Map<String, BasicAccount> ccRecords = null;
    List<ActionType> batchActions = null;


    @Before
    public void setUp() throws Exception {

        ccRecords = new TreeMap<String, BasicAccount>();
        batchActions = new ArrayList<ActionType>();

        String[] argv2 = new String[]{"Add Tom 4111111111111111 $1000",
                "Add Lisa 5454545454545454 $3000",
                "Add Quincy 1234567890123456 $2000",
                "Charge Tom $500",
                "Charge Tom $800",
                "Charge Lisa $7",
                "Credit Lisa $100",
                "Credit Quincy $200",

        };


        ActionType action = null;

        for (int counter = 0; counter < argv2.length; counter++) {
            if (argv2[counter].split(" ").length == 4) {

                String[] rawData = argv2[counter].split(" ");


                action = new ActionType(rawData[0], rawData[1], rawData[2], Float.valueOf(rawData[3].substring(1)).floatValue());

            } else {

                String[] rawData = argv2[counter].split(" ");


                action = new ActionType(rawData[0], rawData[1], Float.valueOf(rawData[2].substring(1)).floatValue());

            }

            batchActions.add(action);
        }


    }

    @After
    public void tearDown() throws Exception {
        ccRecords = null;
        batchActions = null;
    }

    @Test
    public void processRecords() throws Exception {

        Map tempMap = TransactionProcessor.processRecords(ccRecords, batchActions);

        Assert.assertNotNull(tempMap);
        Assert.assertEquals(tempMap.size(), 3, 0);


    }

}