package com.email.send;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailSenderApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailSenderApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		// service.sendSimpleEmail("p123abhi@gmail.com", "This is the email body...",
		// "TThis is the email subject...");

		service.sendEmailWithAttachment("nithishadhiyan03@gmail.com", "This is the attachment email body...",
				"This is the attachment email subject...",
				"C:\\Users\\richard\\Downloads\\CUSTOMER LOYALTY PROGRAM.pdf");

	}
}
