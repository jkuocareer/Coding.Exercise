package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CreditCardSystemTest {

    final String filePath = getClass().getResource("../../TestFile.txt").getPath();

    Scanner scanner = null;
    Map ccRecordPool = null;


    @Before
    public void setUp() throws Exception {

        System.out.println(filePath);

        ccRecordPool = new TreeMap();

        CreditCardSystem.readFromFile(filePath, ccRecordPool);

    }

    @After
    public void tearDown() throws Exception {
        ccRecordPool = null;

    }

    @Test
    public void printReport() throws Exception {
        String sampleReport = "Lisa: $-93.0\n" +
                "Quincy: error\n" +
                "Tom: $500.0\n";

        Assert.assertEquals(CreditCardSystem.printReport(ccRecordPool).toString(), sampleReport);

    }

}