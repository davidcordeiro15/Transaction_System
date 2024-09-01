package com.David.Transaction_System.Transaction_System.Counts;

//Record necessário para tratar os dados gerados pelas requisições HTTP
public record ClientRequest(String nameClient, String cpfClient) {
    
}
