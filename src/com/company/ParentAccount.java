package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParentAccount extends BasicAccount {

    // operation thread safety
    List<BasicAccount> childAccounts = Collections.synchronizedList(new ArrayList<BasicAccount>());

    ParentAccount(String firstName, String lastName, String accountNumber, float creditLine) {
        super(firstName, lastName, accountNumber, creditLine);
    }


}
