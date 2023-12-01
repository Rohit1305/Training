package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.service.EmailSenderService;

@RestController
@RequestMapping("/app")
public class EmailController {
	@Autowired
	private EmailSenderService service;
	public EmailController(EmailSenderService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value = "/send")
	public String sendmail(@RequestParam String toEmail,
			@RequestParam String subject, 
			@RequestParam String body) {
		
		service.sendEmail(toEmail,subject,body);
		return "Mail Sent successfully";
	}
//	@GetMapping(value = "/sendWithAttachment")
//    public String sendMailWithAttachment(
//            @RequestParam String toEmail,
//            @RequestParam String subject,
//            @RequestParam String body,
//            @RequestParam String attachmentPath) {
//        
//        service.sendEmailWithAttachment(toEmail, subject, body, attachmentPath);
//        return "Mail with attachment sent successfully";
//    }

}
