package model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import repository.EmailRep;

public class Email implements EmailRep{
	
	public void enviarCorreo(String correo) {
		
		final String username = "pruebadeew@gmail.com";
		final String password = "34Masasa-";
		String toEmail = "pruebadeew@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		
		properties.put("mail.smtp.starttls.enable", "true");
		/**/properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
			
		});
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.addRecipient (Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Confirmación pedido");
			msg.setText("Ha realizado su pedido con éxito, gracias por su compra.");
			Transport.send(msg);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
