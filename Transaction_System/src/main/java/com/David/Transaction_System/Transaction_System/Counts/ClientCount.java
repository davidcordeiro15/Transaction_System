package com.David.Transaction_System.Transaction_System.Counts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter 
//O lombook vai gerar todos os métodos de Get para a classe Clients
@NoArgsConstructor
//Pede ao lombook par declarar um construtor sem argumentos, permitindo criar e manipular os dados
@AllArgsConstructor
//Pede ao lombook para criar um construtor que recebe todos os argumentos

//Criando a classe de clientes
public class ClientCount {
    private String nameClient;
    private String cpfClient; 

   
}
