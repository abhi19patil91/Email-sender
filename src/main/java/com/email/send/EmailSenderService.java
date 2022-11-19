package com.email.send;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toMail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("abhi19patil91@gmail.com");
		message.setTo(toMail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("mail send...");

	}

	public void sendEmailWithAttachment(String toMail, String body, String subject, String attachment) throws MessagingException {

		MimeMessage mimeMessage = mailSender.createMimeMessage();		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setFrom("abhi19patil91@gmail.com");
		helper.setTo(toMail);
		helper.setText(body);
		helper.setSubject(subject);
		
		FileSystemResource fileSystem = new FileSystemResource(new File(attachment));
		
		helper.addAttachment(fileSystem.getFilename(), fileSystem);
		
		mailSender.send(mimeMessage);
		System.out.println("mail send...");
	}

}
