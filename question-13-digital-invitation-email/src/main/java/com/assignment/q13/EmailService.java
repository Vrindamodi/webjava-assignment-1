package com.assignment.q13;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

    public void sendInvitation(String recipient, String subject, String text) throws MessagingException {
        if (recipient == null || recipient.trim().equals("") || subject == null || subject.trim().equals("")
                || text == null || text.trim().equals("")) {
            throw new IllegalArgumentException("Recipient, subject and message are required.");
        }
        if (!recipient.contains("@") || !recipient.contains(".")) {
            throw new IllegalArgumentException("Recipient email is invalid.");
        }

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
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
    }
}
