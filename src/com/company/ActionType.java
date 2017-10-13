package com.company;

public class ActionType {

    public final static int ADD_COMMAND_OP = 1;
    public final static String ADD_COMMAND = "add";

    public final static int CHARGE_COMMAND_OP = 2;
    public final static String CHARGE_COMMAND = "charge";

    public final static int CREDIT_COMMAND_OP = 3;
    public final static String CREDIT_COMMAND = "credit";


    private int commandAction = 0;
    private String name;
    private float amount;
    private String creditCardNumber = "";

    ActionType(String cmd, String name, String creditCardNumber, float amount) {
        if (cmd.compareToIgnoreCase(ADD_COMMAND) == 0) {
            commandAction = ADD_COMMAND_OP;
            this.creditCardNumber = creditCardNumber;

        } else if (cmd.compareToIgnoreCase(CHARGE_COMMAND) == 0) {
            commandAction = CHARGE_COMMAND_OP;
        } else {
            commandAction = CREDIT_COMMAND_OP;
        }

        this.name = name;
        this.amount = amount;

    }

    ActionType(String cmd, String name, float amount) {
        if (cmd.compareToIgnoreCase(ADD_COMMAND) == 0) {
            commandAction = ADD_COMMAND_OP;
            this.creditCardNumber = "";

        } else if (cmd.compareToIgnoreCase(CHARGE_COMMAND) == 0) {
            commandAction = CHARGE_COMMAND_OP;
        } else {
            commandAction = CREDIT_COMMAND_OP;
        }

        this.name = name;
        this.amount = amount;

    }

    public int getCommand() {
        return this.commandAction;
    }

    public String getName() {
        return this.name;
    }

    public float getAmout() {
        return this.amount;
    }

    /**
     * operation amount
     *
     * @param amount
     */
    protected void setAmout(float amount) {
        this.amount = amount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    protected void setCreditCardNumber(String name) {
        this.creditCardNumber = name;
    }


}
