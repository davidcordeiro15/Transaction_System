package com.David.Transaction_System.Transaction_System.TransactionClass;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;



@Repository
//Criando um repositório para as transações
public class TransactionRepository { 
    //Lista para o histórico de transações
    private final List<Transaction> transactionList = new ArrayList<>(); 

    //Método que armazena uma nova transação
    public void addTransaction(Transaction transaction){
        transactionList.add(transaction);
    }
    // Retorna o histórico de transações realizadas pela empresa
    public List<Transaction> getTransactions(String cnpj) {
        //lista das últimas transações pelo CNPJ da empresa
        List<Transaction> lastedTransactions = new ArrayList<>();
        //Vai procurar na lista de transações 
        for (Transaction transaction : transactionList) {
            //Se o CNPJ da transação for igual ao CNPJ que já tenha feito uma transação vai adicionar na lista de últimas transações
            if (transaction.getCnpjTransaction().equals(cnpj)){
                lastedTransactions.add(transaction); 
            }
        }
        return lastedTransactions;
        
    }
}