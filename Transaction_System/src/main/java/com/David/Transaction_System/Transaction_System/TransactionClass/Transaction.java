package com.David.Transaction_System.Transaction_System.TransactionClass;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter 
//O lombook vai gerar todos os métodos de Get para a classe Clients
@NoArgsConstructor
//Pede ao lombook par declarar um construtor sem argumentos, permitindo criar e manipular na transição
@AllArgsConstructor
//Pede ao lombook para criar um construtor que recebe todos da transação
@Component
//Criando a classe de Transações
public class Transaction {
    String cnpjTransaction;
    String cpfTransaction; 
    Double value; 
    String emailTransaction;
}
