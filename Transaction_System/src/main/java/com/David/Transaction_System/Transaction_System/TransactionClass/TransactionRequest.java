package com.David.Transaction_System.Transaction_System.TransactionClass;
//Record necessário para tratar os dados gerados pelas requisições HTTP
public record TransactionRequest( String cnpjTransaction, String cpfTransaction, Double value, String emailTransaction) {
    
}
