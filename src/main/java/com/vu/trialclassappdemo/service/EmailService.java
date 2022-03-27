package com.vu.trialclassappdemo.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.vu.trialclassappdemo.form.EmailForm;

@Service
public class EmailService {
	
	public void sendEmail(EmailForm emailForm) {
		Session senderSession = getSenderSession();
		
		try {
			String to = emailForm.getRecipients();
			InternetAddress[] receivers = InternetAddress.parse(to, true);
			
			MimeMessage myEmail = new MimeMessage(senderSession);
			myEmail.setRecipients(Message.RecipientType.TO, receivers);
			myEmail.setSubject(emailForm.getSubject());
			myEmail.setText(emailForm.getMessages());
			
			Transport.send(myEmail);
			System.out.println("Gửi email thành công!");
		} catch(MessagingException e) {
			System.out.println("Gửi email thất bại");
			throw new RuntimeException(e);
		}
	}

	private Session getSenderSession() {
		Properties senderProps = new Properties();
		senderProps.put("mail.smtp.auth", true);
		senderProps.put("mail.smtp.host", "smtp.gmail.com");
		senderProps.put("mail.smtp.socketFactory.port", 465);
		senderProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		senderProps.put("mail.smtp.port", 465);
		
		Session senderSession = Session.getDefaultInstance(senderProps, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vutrialclass.test@gmail.com", "Password!123");
			}
		});
		
		return senderSession;
	}
}
