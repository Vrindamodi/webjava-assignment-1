package com.assignment.q9;

import javax.naming.InitialContext;

public class BankClient {

    public static void main(String[] args) throws Exception {
        // JNDI name of the EJB on the application server
        String jndiName = "java:global/bank-ejb/BankServiceBean!com.assignment.q9.BankServiceRemote";
        if (args.length > 0) {
            jndiName = args[0];
        }

        InitialContext context = new InitialContext();
        BankServiceRemote bank = (BankServiceRemote) context.lookup(jndiName);

        System.out.println("Starting balance: " + bank.getBalance());
        System.out.println("After deposit of 500: " + bank.deposit(500));
        System.out.println("After withdrawal of 200: " + bank.withdraw(200));
        System.out.println("Final balance: " + bank.getBalance());
    }
}
