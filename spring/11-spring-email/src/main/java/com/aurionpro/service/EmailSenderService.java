package com.aurionpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
	
	public EmailSenderService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public void sendEmail(String toEmail,String subject, String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("rohitsabat2000@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("Mail sent successfully");
	}

//	public void sendEmailWithAttachment(String toEmail, String subject, String body, String attachmentPath) {
//		
//	}
}
