package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CreditCardSystem {


    public static void main(String[] argv) {


        Scanner command = new Scanner(System.in);

        printCommandPrompt();


        boolean running = true;
        String commandState = "";
        Map ccRecordPool = new TreeMap();  // map will store {name,BasicAccount}

        while (running) {
            switch (commandState.length() == 0 ? command.nextLine() : commandState) {

                case "1":

                    if (commandState.length() == 0) {

                        System.out.println("Feeding from file path, Please provide a file path");
                        commandState = "1";

                    } else {

                        try {

                            readFromFile(command.nextLine().trim(), ccRecordPool);

                            if (commandState.length() > 0) {

                                commandState = "";
                                System.out.println("File has been processed! Please use command 3 to print records");

                                printCommandPrompt();

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            printCommandPrompt();
                        }
                    }


                    break;

                case "2":

                    if (commandState.length() == 0) {

                        System.out.println("Feeding from command line: ");
                        commandState = "2";

                    } else {

                        readFromCommand(command.nextLine().trim(), ccRecordPool);

                        if (commandState.length() > 0) {

                            commandState = "";
                            printCommandPrompt();

                        }
                    }

                    break;

                case "3":
                    System.out.println("Printing Report");
                    CreditCardSystem.printReport(ccRecordPool);
                    printCommandPrompt();
                    break;
                case "4":
                    System.out.println("Clear CC Records");
                    CreditCardSystem.clearRecords(ccRecordPool);

                case "5":
                    System.out.println("Exiting System");
                    running = false;
                    break;


                default:
                    System.out.println("Command not recognized! Please try again");
                    printCommandPrompt();

                    break;

            }

        }

        command.close();

        System.exit(0);


    }


    private static void clearRecords(Map ccRecordPool) {

        ccRecordPool.clear();
        System.out.println("Printing Report");

    }

    private static void readFromCommand(String data, Map ccRecordPool) {

        //String data = command.nextLine().trim();
        ActionType action = null;
        List<ActionType> list = new ArrayList<ActionType>();

        if (data.split(" ").length == 4) {
            String[] rawData = data.split(" ");
            action = new ActionType(rawData[0], rawData[1], rawData[2], Float.valueOf(rawData[3].substring(1)).floatValue());
        } else {
            String[] rawData = data.split(" ");
            action = new ActionType(rawData[0], rawData[1], Float.valueOf(rawData[2].substring(1)).floatValue());
        }

        list.add(action);

        ccRecordPool = TransactionProcessor.processRecords(ccRecordPool, list);


    }

    protected static void readFromFile(String filePath, Map ccRecordPool) throws Exception {

        //String filePath = command.nextLine().trim();
        System.out.println("file Path is " + filePath);

        BufferedReader br = null;


        try {

            br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            ActionType action = null;
            List<ActionType> list = new ArrayList<ActionType>();

            while (line != null) {
                if (line.split(" ").length == 4) {
                    String[] rawData = line.split(" ");
                    action = new ActionType(rawData[0], rawData[1], rawData[2], Float.valueOf(rawData[3].substring(1)).floatValue());
                } else {
                    String[] rawData = line.split(" ");
                    action = new ActionType(rawData[0], rawData[1], Float.valueOf(rawData[2].substring(1)).floatValue());
                }

                list.add(action);
                line = br.readLine();
            }
            ccRecordPool = TransactionProcessor.processRecords(ccRecordPool, list);

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printCommandPrompt() {

        System.out.println("");

        System.out.println("     Please Enter command: ");
        System.out.println("");
        System.out.println("           Feed from file 1 -");
        System.out.println(" Feed from command prompt 2 -");
        System.out.println("             Print Report 3 -");
        System.out.println("            Clear Records 4 -");
        System.out.println("              Exit System 5 -");

    }

    public static StringBuilder printReport(Map<String, BasicAccount> ccRecordPool) {
        Iterator<BasicAccount> it = ccRecordPool.values().iterator();
        StringBuilder stb = new StringBuilder();
        stb.setLength(0);

        while (it.hasNext()) {
            BasicAccount ba = it.next();
            if (ba.getCreditLine() == Float.MAX_VALUE) {
                stb.append(ba.getFirstName() + ": " + ba.getAccountNumber());
                stb.append("\n");

            } else {
                stb.append(ba.getFirstName() + ": " + "$" + ba.getAccountBalance());
                stb.append("\n");

            }

        }

        System.out.println(stb.toString());
        System.out.println("");

        if (ccRecordPool.size() == 0) {
            System.out.println("Report is empty! ");
            System.out.println("");

        }

        return stb;

    }
}
