package com.assignment.q13;

import java.util.Scanner;

public class InvitationApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Recipient email: ");
        String recipient = sc.nextLine();
        System.out.print("Subject: ");
        String subject = sc.nextLine();
        System.out.print("Invitation message: ");
        String message = sc.nextLine();

        try {
            EmailService service = new EmailService();
            service.sendInvitation(recipient, subject, message);
            System.out.println("Invitation sent successfully.");
        } catch (Exception e) {
            System.out.println("Could not send invitation: " + e.getMessage());
        }
    }
}
