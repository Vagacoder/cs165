package javamailtest;

import static java.lang.System.*;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

/**
 * Example of the Facade design pattern. Mailer hides the complexity of the
 * JavaMail API while not preventing access to it.
 * 
 * Typical usage:
 * <code>Mailer mailer = new Mailer("smtp.gmail.com", "cs165sbcc@gmail.com", password);</code>
 * <code>mailer.send("cs123sbcc@gmail.com", "Won't be long", "Looking forward to it.");</code>
 * 
 * @author sstrenn
 *
 */
public class Mailer {

	String host;
	String user;
	String password;
	Properties props;

	public void send(String to, String subject, String message) throws Exception {
		send(new String[] { to }, subject, message);
	}


	public void send(String[] to, String subject, String message) throws Exception {

		var session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		var mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(user));

		var toAddress = new InternetAddress[to.length];

		// To get the array of addresses
		for (int i = 0; i < to.length; i++)
			toAddress[i] = new InternetAddress(to[i]);

		for (int i = 0; i < toAddress.length; i++)
			mimeMessage.addRecipient(Message.RecipientType.TO, toAddress[i]);
		mimeMessage.setSubject(subject);
		mimeMessage.setText(message);
		var transport = session.getTransport("smtp");
		transport.connect(host, user, password);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
	}


	public Mailer(String host, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;

		var props = getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", user);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		this.props = props;
	}


	public Mailer(Properties props) {
		this.props = props;
	}

}
