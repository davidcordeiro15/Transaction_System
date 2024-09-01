package com.David.Transaction_System.Transaction_System.Email;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
//O lombook vai gerar todos os métodos de Set para a classe email
@Getter 
//O lombook vai gerar todos os métodos de Get para a classe email
@NoArgsConstructor
//Pede ao lombook par declarar um construtor sem argumentos, permitindo criar e manipular os dados
@AllArgsConstructor
//Pede ao lombook para criar um construtor que recebe todos os argumentos
@Component
//Criando a classe de email
public class Email {
    String to;
    String subject;
    String body;
}
