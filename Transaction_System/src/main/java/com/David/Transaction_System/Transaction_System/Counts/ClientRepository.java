package com.David.Transaction_System.Transaction_System.Counts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
//Criando um repositório paraos clientes
public class ClientRepository {
    //Lista com todas os clientes registrados (poderia ser substituido por um banco de dados facilmente)
    private final List<ClientCount> clientList = new ArrayList<>();

    //Método que armazena clientes
    public void addClient(ClientCount client) {
        clientList.add(client); 
    }

    //Método que encontra a empresa baseado no CPF
    public Optional<ClientCount> findByCpf(String cpf){
        return clientList.stream()
        .filter(client -> client.getCpfClient().equals(cpf))
        .findFirst(); 
    }
}
