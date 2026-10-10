package com.assignment.q9;

import javax.ejb.Stateful;

// Stateful bean, so the balance is kept inside the EJB for each client
@Stateful
public class BankServiceBean implements BankServiceRemote {

    private double balance = 1000;

    public double deposit(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("Deposit amount must be positive");
        }
        balance = balance + amount;
        return balance;
    }

    public double withdraw(double amount) throws BankException {
        if (amount <= 0) {
            throw new BankException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new BankException("Insufficient balance");
        }
        balance = balance - amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
}
