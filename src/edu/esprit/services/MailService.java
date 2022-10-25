/* 
  * To change this license header, choose License Headers in Project Properties. 
  * To change this template file, choose Tools | Templates 
  * and open the template in the editor. 
  */ 
 package edu.esprit.services; 
  
 import java.util.Properties; 
 import javax.mail.Message; 
 import javax.mail.MessagingException; 
 import javax.mail.PasswordAuthentication; 
 import javax.mail.Session; 
 import javax.mail.Transport; 
 import javax.mail.internet.InternetAddress; 
 import javax.mail.internet.MimeMessage; 
  
 /** 
  * 
  * @author MSI Si Ahmed 
  */ 
 public class MailService { 
  
     public Integer SendMail(String tomail, String mdpt) { 
         final String username = "oumaima.majdoub@esprit.tn"; 
         final String password = "vrbgxvceyzhtspwa"; 
  
         Properties prop = new Properties(); 
         prop.put("mail.smtp.host", "smtp.gmail.com"); 
         prop.put("mail.smtp.port", "587"); 
         prop.put("mail.smtp.auth", "true"); 
         prop.put("mail.smtp.starttls.enable", "true"); //TLS 
  
         Session session = Session.getInstance(prop, 
                 new javax.mail.Authenticator() { 
             protected PasswordAuthentication getPasswordAuthentication() { 
                 return new PasswordAuthentication(username, password); 
             } 
         }); 
  
         try { 
  
             Message message = new MimeMessage(session); 
             message.setFrom(new InternetAddress("oumaima.majdoub@esprit.tn")); 
             message.setRecipients( 
                     Message.RecipientType.TO, 
                     InternetAddress.parse(tomail) 
             ); 
             message.setSubject("TReset Mot de passe de votre compte"); 
             message.setText("Dear " + tomail + "," 
                     + "\n\n votre mot de passe: " + mdpt); 
  
             Transport.send(message); 
  
             System.out.println("Done"); 
             return 1; 
  
         } catch (MessagingException e) { 
             e.printStackTrace(); 
             return 0; 
         } 
     } 
  
 }