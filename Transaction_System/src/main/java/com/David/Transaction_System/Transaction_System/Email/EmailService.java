package com.David.Transaction_System.Transaction_System.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;


@Repository
//Criando um repositório para os emails
public class EmailService {
    //Declarando a classe do javaMail que será usada
    private final JavaMailSender mailSender; 
    
    //Criando um serviço para mandar emails
    public EmailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }
    //Método que envia emails
    public void sendEmail(Email email){
        var message = new SimpleMailMessage();
        message.setFrom("noreply@email.com");
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody()); 
        mailSender.send(message);
    }
}
