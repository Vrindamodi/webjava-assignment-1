package com.assignment.q9;

import javax.ejb.Remote;

@Remote
public interface BankServiceRemote {
    double deposit(double amount) throws BankException;

    double withdraw(double amount) throws BankException;

    double getBalance();
}
