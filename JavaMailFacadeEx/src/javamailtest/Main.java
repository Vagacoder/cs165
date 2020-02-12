package javamailtest;

import static sbcc.Core.*;

import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

public class Main {

	public static void main(String[] args)
			throws AddressException, MessagingException, IOException {

		String host = "smtp.gmail.com";
		String from = "cs165sbcc@gmail.com";
		String pass = readFile("pwd");
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = { "cs123sbcc@gmail.com" };

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses
		for (int i = 0; i < to.length; i++)
			toAddress[i] = new InternetAddress(to[i]);

		for (int i = 0; i < toAddress.length; i++)
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		message.setSubject("This is simple?");
		message.setText("Hello from SBCC!");
		Transport transport = session.getTransport("smtp");
		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

}
