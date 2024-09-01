package com.David.Transaction_System.Transaction_System.Email;

//Record necessário para tratar os dados gerados pelas requisições HTTP
public record EmailRequest(String to, String subject, String body) {
    
}
