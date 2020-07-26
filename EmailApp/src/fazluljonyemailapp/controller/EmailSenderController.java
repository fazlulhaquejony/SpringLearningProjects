package fazluljonyemailapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fazluljonyemailapp.model.EmailSender;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Controller
@RequestMapping("/emailsender")
public class EmailSenderController {
	
	@RequestMapping("/mailsend")
	public String appSender(Model themodel) {
		
		EmailSender emailsender = new EmailSender();
		themodel.addAttribute("email", emailsender);
		
		return "mailsend";
	}
	
	@RequestMapping("/processEmail")
	public String processEmail(@ModelAttribute("email") EmailSender emailsender  ) {
		
		
		//Add recipient details
		//String to = "fazlulhaquue.jony@gmail.com";
		 String to = emailsender.getTo();
		
		//Add sender details
		
		String from = "hhaque141169@bscse.uiu.ac.bd";
		final String username = "hhaque141169@bscse.uiu.ac.bd" ;
		final String password ="1623300@";
		String  host = "smtp.gmail.com";                                 
		
		//put details to the property
		Properties props = new Properties();
		//props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.user", "hhaque141169@bscse.uiu.ac.bd");
		props.setProperty("mail.smtp.password", "1623300@");
		props.setProperty("mail.smtp.auth", "true"); 
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");
		
		//***** Password Authentication Showing error***********8
		
		// get the session object with authentication
	    
	    Session session = Session.getInstance(props,
	    	    new Authenticator() {
	    	        protected PasswordAuthentication  getPasswordAuthentication() {
	    	        return new PasswordAuthentication(
	    	        		username, password);
	    	                }
	    	    });
	    
	    
		//default session
		//Session session = Session.getDefaultInstance(props);
		
		try {
		// create a default MimeMessge object
		Message message = new MimeMessage(session);
		
		// Add form details
		message.setFrom(new InternetAddress(from));
		
		// Add Recipient details
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		
		// Add mail's Subject
		message.setSubject(emailsender.getSub());
		
		
	    //** add massage body **
		//mimeBody Part is for add mail body helper
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(emailsender.getBody());
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
			
		
        // Send the complete message parts
        message.setContent(multipart); 
        
        // Send message
        Transport.send(message);
		}
		catch(MessagingException e)
		{
			 throw new RuntimeException(e);
		}  
		
		
	
		return "emailConfirm";
	}
	

}
