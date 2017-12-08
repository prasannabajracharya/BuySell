package edu.mum.client.config;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class MailUtil {

	private MailSender mailServer; 


	public MailUtil(MailSender mailServer) {
		super();
		this.mailServer = mailServer;
	}

	public void sendEmail(String toAddress, String fromAddress,
			String subject, String msgBody) {
		System.out.println("I am from MailUtil.sendEmail"+msgBody);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromAddress);
		message.setTo(toAddress);
		message.setSubject(subject);
		message.setText(msgBody);
		message.setReplyTo("prasanna.bajracharya@gmail.com");
		message.setSentDate(Calendar.getInstance().getTime());
		System.out.println("My message:"+message);
		mailServer.send(message);
		System.out.println("Email sent...");
	}
}
