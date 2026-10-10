package com.assignment.q9;

// Checked exception, so the container keeps the bean (and its balance) after an error
public class BankException extends Exception {

    public BankException(String message) {
        super(message);
    }
}
