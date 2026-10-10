package com.assignment.q10;

import javax.naming.InitialContext;

public class ResultClient {

    public static void main(String[] args) throws Exception {
        String jndiName = "java:global/result-ejb/ResultServiceBean!com.assignment.q10.ResultServiceRemote";
        if (args.length > 0) {
            jndiName = args[0];
        }

        InitialContext context = new InitialContext();
        ResultServiceRemote service = (ResultServiceRemote) context.lookup(jndiName);

        StudentResult result = service.process("MCA101", 78, 84, 88);
        System.out.println("Roll Number: " + result.getRollNumber());
        System.out.println("Total: " + result.getTotal());
        System.out.println("Percentage: " + result.getPercentage());
        System.out.println("Grade: " + result.getGrade());
    }
}
