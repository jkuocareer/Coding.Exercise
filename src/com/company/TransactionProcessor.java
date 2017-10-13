package com.company;

import java.util.List;
import java.util.Map;

public class TransactionProcessor {

    private Map ccRecords;
    private List batchActions;

    TransactionProcessor(Map records, List actionType) {
        this.ccRecords = records;
        this.batchActions = actionType;
    }


    public static Map processRecords(Map<String, BasicAccount> ccRecords, List<ActionType> batchActions) throws IllegalStateException {

        for (int counter = 0; counter < batchActions.size(); counter++) {
            ActionType act = batchActions.get(counter);
            switch (act.getCommand()) {
                case ActionType.ADD_COMMAND_OP:
                    if (!ccRecords.containsKey(act.getName())) {
                        // we validate credit card number here using self code Luhn 10 Algorithm
                        boolean validNumber = LuhnAlgorithm.isAValidCardSpeed(act.getCreditCardNumber());
                        if (!validNumber) {
                            act.setCreditCardNumber("error");
                            act.setAmout(Float.MAX_VALUE);
                        }

                        BasicAccount ba = new BasicAccount(act.getName(), act.getName(), act.getCreditCardNumber(), act.getAmout());
                        ccRecords.put(ba.getFirstName(), ba);

                    } else {

                        // record found and try match with cc number, if matches throw duplicate exception

                        BasicAccount ba = ccRecords.get(act.getName());
                        if (ba.getAccountNumber().compareToIgnoreCase(act.getCreditCardNumber()) == 0)
                            throw new IllegalStateException("Account Already Existed");

                    }

                    break;
                case ActionType.CHARGE_COMMAND_OP:
                    if (!ccRecords.containsKey(act.getName())) {

                        // account should already existed  if not found throw IllegalStateException
                        throw new IllegalStateException("Account not found! Please create an account first");


                    }
                    try {
                        BasicAccount ba = ccRecords.get(act.getName());
                        if ((ba.getAccountNumber().compareToIgnoreCase("error") == 0) && (ba.getCreditLine() == Float.MAX_VALUE)) {

                        } else {
                            ba.addBalance(act.getAmout());
                        }
                    } catch (Exception e) {
                        //throw e;
                        System.out.println(e.getMessage());
                    }


                    break;
                case ActionType.CREDIT_COMMAND_OP:

                    // paying debt should never have to worry about exceeding credit line
                    BasicAccount ba = ccRecords.get(act.getName());
                    if ((ba.getAccountNumber().compareToIgnoreCase("error") == 0) && (ba.getCreditLine() == Float.MAX_VALUE)) {

                    } else {
                        ba.addBalance(act.getAmout() * -1);
                    }


                    break;
                default:
                    throw new IllegalStateException("Command not support!");

            }

        }

        return ccRecords;

    }

}
