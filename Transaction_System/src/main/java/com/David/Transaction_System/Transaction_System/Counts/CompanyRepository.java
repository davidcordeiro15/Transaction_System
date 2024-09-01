package com.David.Transaction_System.Transaction_System.Counts;

import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Criando um repositório para as empresas
@Repository
public class CompanyRepository {
    //Lista com todas as empresas registradas (poderia ser substituido por um banco de dados facilmente)
    private final List<Company> companies = new ArrayList<>();
    
    //Método que armazena empresas
    public void addCompany(Company company) {
        companies.add(company);
    }

    //método que atualiza o saldo da empresa, baseado nas transações
    public void updateBalence(String cnpj, Double value){
        // Encontrar a empresa com o CNPJ correspondente
        for (Company company : companies) {
            if (company.getCnpjCompany().equals(cnpj)) {
                // Atualizar o balanço da empresa, já com a taxa de 5% do sistema
                if (value>0){
                    company.setBalanceCompany(company.getBalanceCompany() + value - value*0.05);
                } else {
                    company.setBalanceCompany(company.getBalanceCompany() + value + value*0.05);
                }
                return; // Encerra o método após encontrar e atualizar a empresa
            }
        }
        
                        
    }
    
    //Método que encontra a empresa baseado no CNPJ
    public Optional<Company> findByCnpj(String cnpj) {
        return companies.stream()
                        .filter(company -> company.getCnpjCompany().equals(cnpj))
                        .findFirst();
    }
}
