/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Utility;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author BADBOY
 */
public class SendMail {

    public void SendMailClient() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");


        //  javax.mail.Session mailSession = javax.mail.Session.getDefaultInstance(props);
        javax.mail.Session mailSession;
        Message simpleMessage = null;

        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        try {
            mailSession = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(Username, Password);
                }
            });
            simpleMessage = new MimeMessage(mailSession);
            fromAddress = new InternetAddress("badboy1707@gmail.com");
            toAddress = new InternetAddress("anhchang_langthanghn@yahoo.com");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        try {

            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(RecipientType.TO, toAddress);
            simpleMessage.setSubject("hello");
            simpleMessage.setText("chao ban");

            Transport.send(simpleMessage);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private String Host = "smtp.gmail.com";
    private final String Username = "badboy1707@gmail.com";
    private final String Password = "dnvyvndhf";
    private String MailFrom = "badboy1707@gmail.com";

    public void SendMailForGetPass(String userName, String MailTo, String password) {

        try {

            String MailMessage = "\n\n Hi.." + userName
                    + "\n\n You or someone requested retrieve password form Doctor Forum. "
                    + "\n\n You password :" + password
                    + "\n\n Regards,\nDoctor Forum.";

            // Create object
            // One connection to mail server
            // Call properties before sent mail
            Properties props = new Properties();
            props.clear();

            // Get name of server
            // props.put("mail.smtp.host", Host);

            // props.put("mail.smtp.auth", "true");

            // Yahoo mail sent port 587
//            props.put("mail.smtp.port", "587");
//            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            // Connect to server , create one session, set password into
            javax.mail.Session session = javax.mail.Session.getDefaultInstance(props);
//            javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(Username, Password);
//                }
//            });

            session.setDebug(true);

            // create object message
            Message msg = new MimeMessage(session);

            // set email address from and to
            Address to = new InternetAddress(MailTo);
            Address from = new InternetAddress(MailFrom);

            // set all infor to object Message
            msg.setContent(MailMessage, "text/plain");
            msg.setFrom(from);
            msg.setRecipient(Message.RecipientType.TO, to);
            msg.setSubject("do dinh lam");

            // Start send
            Transport.send(msg);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
