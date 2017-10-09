/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vend.controller;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ALM-PC
 */
public class JavaMailApp {
    private Properties props;
    private Session session;
    private String remetente;
    
    public JavaMailApp(String mail, String pass){
        this.remetente = mail;
        
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        session = Session.getDefaultInstance(
            props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(mail, pass);
                }
            }
        );
        
        session.setDebug(true);
    }
    
    public void enviarEmail(String destinatario, String corpoEmail){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            Address[] toUser = InternetAddress.parse(destinatario);  
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Pedido recebido");//Assunto
            message.setText(corpoEmail);
            
            /**Método para enviar a mensagem criada*/
            Transport.send(message);
            System.out.println("Deu Certo");
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    
    
}
