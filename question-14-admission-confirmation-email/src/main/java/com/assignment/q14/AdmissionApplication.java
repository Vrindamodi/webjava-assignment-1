package com.assignment.q14;

import java.util.Scanner;

public class AdmissionApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student email: ");
        String email = sc.nextLine();
        System.out.print("Student name: ");
        String name = sc.nextLine();
        System.out.print("Application ID: ");
        String applicationId = sc.nextLine();

        try {
            AdmissionConfirmationService service = new AdmissionConfirmationService();
            service.sendConfirmation(email, name, applicationId);
            System.out.println("Admission confirmation sent successfully.");
        } catch (Exception e) {
            System.out.println("Could not send confirmation: " + e.getMessage());
        }
    }
}
