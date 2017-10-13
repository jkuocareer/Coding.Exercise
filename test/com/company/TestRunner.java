package com.company;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] argv) {
        Result result = JUnitCore.runClasses(TestSuite.class);


        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Test suite ran and result is : " + result.wasSuccessful());

    }
}
