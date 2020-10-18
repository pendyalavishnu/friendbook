package com.example.friendbook.service;

import com.example.friendbook.exception.SpringFriendbookException;
import com.example.friendbook.model.NotificationEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;


@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailContentBuilder mailContentBuilder;

    @Async
    void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator message_preparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("springreddit@email.com");
            messageHelper.setTo(notificationEmail.getTxt_recipient());
            messageHelper.setSubject(notificationEmail.getTxt_subject());
            messageHelper.setText(notificationEmail.getTxt_body());
        };
        try {
            mailSender.send(message_preparator);
            System.out.println("Activation email sent!!");
        } catch (MailException e) {
            System.out.println("Exception occurred when sending mail");
            throw new SpringFriendbookException("Exception occurred when sending mail to " + notificationEmail.getTxt_recipient(), e);
        }
    }
}
