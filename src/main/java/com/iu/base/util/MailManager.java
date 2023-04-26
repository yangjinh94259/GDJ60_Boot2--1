package com.iu.base.util;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MailManager {
 
    @Value("${spring.mail.username}")
    private String sender;
    
    @Autowired
    private JavaMailSender javaMailSender;
 
    public void sendEmail(String to, String subject, String con) throws Exception {
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	mimeMessage.setFrom(sender);
    	mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
    	mimeMessage.setSubject(subject);
    	mimeMessage.setText(con);
    	javaMailSender.send(mimeMessage);
    	
    	//HTML태그를 무시하고 그래도 Text로 전송
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(sender);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(con);
//        javaMailSender.send(message);
    }
}