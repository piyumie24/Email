package com.manishchhabra.blog.email;

import com.manishchhabra.blog.model.EmailMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/27/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmailSender {


    private MailSender mailSender;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendEmail(EmailMessage emailMessage) throws MailException {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(emailMessage.getEmail());
        message.setSubject(emailMessage.getName());
        message.setText(emailMessage.getMessage());
        //sending the message
        mailSender.send(message);

    }

}
