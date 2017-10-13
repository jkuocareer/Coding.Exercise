package com.company;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ActionTypeTest.class,
        BasicAccountTest.class,
        CreditCardSystemTest.class,
        LuhnAlgorithmTest.class,
        TransactionProcessorTest.class,
})
public class TestSuite {

}
