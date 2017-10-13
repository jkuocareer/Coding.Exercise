package com.company;

public class BasicAccount {

    private double accountBalance = 0;
    private String accountNumber = "";
    private String firstName = "";
    private String lastName = "";
    private double creditLine = 0;

    BasicAccount(String firstName, String lastName, String accountNumber, double creditLine) throws IllegalStateException {

        accountBalance = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.creditLine = creditLine;

    }

    public static void main(String[] argv) {

        new BasicAccount("Tom", "Tom", "41111111111111111", 1000f);

    }

    public synchronized double getAccountBalance() {

        return this.accountBalance;
    }


    public double getCreditLine() {
        return this.creditLine;
    }

    public String getAccountNumber() {

        return this.accountNumber;
    }

    public String getAccountNumberLastFourDigits() {
        // for public access

        return (this.accountNumber + "").substring((this.accountNumber + "").length() - 4);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    protected synchronized void addBalance(double accountBalance) throws IllegalStateException {

        if (accountBalance + this.getAccountBalance() > this.getCreditLine())
            throw new IllegalStateException("Charge Denied! Future Balance will Exceed credit line");

        this.accountBalance += accountBalance;

    }


}
