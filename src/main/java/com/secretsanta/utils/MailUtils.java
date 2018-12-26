package com.secretsanta.utils;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	
	public static final String username = "abc.com";
	public static final String password = "abcpasswd";

	// Send a simple, single part, text/plain e-mail
	public static boolean sendMail(String to_emailId,
			String subject, String content) {

		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to_emailId));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	 // Send mail to Santa Admin for Record
         public static boolean sendMailRecord(String to_emailId,
				String subject, String content) {

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to_emailId));
				message.setSubject(subject);
				message.setText(content);
				Transport.send(message);
				return true;

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}

	public static void main(String[] args) {

	}

}
