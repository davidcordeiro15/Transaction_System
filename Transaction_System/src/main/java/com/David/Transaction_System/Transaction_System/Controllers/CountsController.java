package com.David.Transaction_System.Transaction_System.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.David.Transaction_System.Transaction_System.Counts.ClientCount;
import com.David.Transaction_System.Transaction_System.Counts.ClientRepository;
import com.David.Transaction_System.Transaction_System.Counts.ClientRequest;
import com.David.Transaction_System.Transaction_System.Counts.Company;
import com.David.Transaction_System.Transaction_System.Counts.CompanyRepository;
import com.David.Transaction_System.Transaction_System.Counts.CompanyResquest;





@RestController
@RequestMapping("Company")
public class CountsController {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ClientRepository clientRepository; 
    

    //Post de clientes para entrar, consultar ou registrar uma nova empresa
    @PostMapping(path = "/setCompany")
    public void setCompany(@RequestBody CompanyResquest request) {  
        try {
            Company companys = new Company(request.nameCompany(), request.cnpjCompany(), request.balanceCompany(), request.emailCompany());
            companyRepository.addCompany(companys);  
               
        } catch (Exception e) {
            e.getMessage(); 
        }
    }
    //Post de clientes para entrar, consultar ou registrar um novo cliente
    @PostMapping(path = "/setClient")
    public void setClient(@RequestBody ClientRequest request) {
        try {
            ClientCount client = new ClientCount(request.nameClient(), request.cpfClient());
            clientRepository.addClient(client); 
        } catch (Exception e) {
            e.getMessage(); 
        }
       
    }
    
    //Get das empresas selecionados por CNPJ

    @GetMapping(path = "/getCompany/{cnpj}")
    public Company getCompanyByCnpj(@PathVariable("cnpj") String cnpj) {
        return companyRepository.findByCnpj(cnpj).orElse(null);
    }
    //Get dos clientes selecionados por CPF
    @GetMapping(path = "/getClient/{cpf}")
    public ClientCount getClient(@PathVariable("cpf") String cpf) {
        return clientRepository.findByCpf(cpf).orElse(null);
    }
    
}
    