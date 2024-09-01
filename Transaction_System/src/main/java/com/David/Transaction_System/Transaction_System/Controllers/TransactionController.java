package com.David.Transaction_System.Transaction_System.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.David.Transaction_System.Transaction_System.Counts.CompanyRepository;
import com.David.Transaction_System.Transaction_System.Email.Email;
import com.David.Transaction_System.Transaction_System.Email.EmailService;
import com.David.Transaction_System.Transaction_System.TransactionClass.Transaction;
import com.David.Transaction_System.Transaction_System.TransactionClass.TransactionRepository;
import com.David.Transaction_System.Transaction_System.TransactionClass.TransactionRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("Transaction")
public class TransactionController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private Email email;
    @Autowired 
    private TransactionRepository repository; 
    @Autowired
    private CompanyRepository companyRepository;
    
    @PostMapping(path = "/postTransaction")
    public void postTransaction(@RequestBody TransactionRequest request) {
        try {
            //criar uma nova transação
            Transaction transaction = new Transaction(request.cnpjTransaction(),request.cpfTransaction(),request.value(), request.emailTransaction());
            //Adicionando a transação no histórico
            repository.addTransaction(transaction);
            //Modificando o saldo da empresa, visto o saque ou o depósito
            companyRepository.updateBalence(request.cnpjTransaction(), request.value());   
        } catch (Exception e) {
            e.getMessage(); 
        }
        try {
            email.setTo(request.emailTransaction());
            email.setSubject("Transação Realizada!");
            email.setBody("Uma transação foi realizada para sua empresa!");
            emailService.sendEmail(email);   
        } catch (Exception e) {
            e.getMessage(); 
        }

        return;
    }
    @GetMapping(path ="/getTransaction/{cnpj}")
    public List<Transaction> getTransaction(@PathVariable("cnpj") String cnpj) {
        //mostra o histórico de transações pelo CNPJ a empresa
        return repository.getTransactions(cnpj);
    
    }
    
    
}
