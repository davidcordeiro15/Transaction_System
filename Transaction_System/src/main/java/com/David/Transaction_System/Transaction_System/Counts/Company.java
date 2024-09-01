package com.David.Transaction_System.Transaction_System.Counts;



import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter 
//O lombook vai gerar todos os métodos de Get para a classe company
@NoArgsConstructor
//Pede ao lombook par declarar um construtor sem argumentos, permitindo criar e manipular os dados
@AllArgsConstructor
//Pede ao lombook para criar um construtor que recebe todos os argumentos
@Component
//Criando a classe para a empresa
public class Company {
    private String nameCompany;
    private String cnpjCompany; 
    public Double balanceCompany;   
    private String emailCompany; 
}
