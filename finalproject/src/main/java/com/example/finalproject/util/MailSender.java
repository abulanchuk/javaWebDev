package com.example.finalproject.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;


public class MailSender {
    private static final ResourceBundle bundle;
    private static final String USER_NAME;
    private static final String PASSWORD;
    static {
        bundle = ResourceBundle.getBundle("mail");
        USER_NAME = bundle.getString("mail.smtp.user");
        PASSWORD = bundle.getString("mail.smtp.user.password");
    }

    public void sentEmail(String recipientOfEmail,String subjectOfMail, String text) throws IOException, MessagingException {


        final Properties properties = new Properties();
        properties.load(MailSender.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(USER_NAME));
        message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(recipientOfEmail)));
        message.setSubject(subjectOfMail);
        message.setText(text);

        Transport transport = mailSession.getTransport();
        transport.connect(null, PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

}
