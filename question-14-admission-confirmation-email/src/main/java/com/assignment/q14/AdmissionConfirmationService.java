package com.assignment.q14;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AdmissionConfirmationService {

    public void sendConfirmation(String email, String studentName, String applicationId)
            throws MessagingException {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("A valid student email is required.");
        }
        if (studentName == null || studentName.trim().equals("") || applicationId == null
                || applicationId.trim().equals("")) {
            throw new IllegalArgumentException("Student name and application ID are required.");
        }

        // create the email text using the student details
        String body = "Dear " + studentName + ",\n\n"
                + "Your admission registration has been confirmed.\n"
                + "Application ID: " + applicationId + "\n\n"
                + "Please keep this ID for future communication.\n\n"
                + "Admissions Office";

        // SMTP settings are taken from environment variables
        final String username = System.getenv("SMTP_USERNAME");
        final String password = System.getenv("SMTP_PASSWORD");
        String host = System.getenv("SMTP_HOST");
        String port = System.getenv("SMTP_PORT");
        String from = System.getenv("SMTP_FROM");
        if (username == null || password == null || host == null || from == null) {
            throw new IllegalArgumentException(
                    "Set SMTP_HOST, SMTP_USERNAME, SMTP_PASSWORD and SMTP_FROM environment variables.");
        }
        if (port == null) {
            port = "587";
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Admission Confirmation - " + applicationId);
        message.setText(body);
        Transport.send(message);
    }
}
