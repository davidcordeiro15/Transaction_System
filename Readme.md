# Projeto de Transações entre contas com Spring Boot 

Este é um projeto que utiliza Spring Boot  para gerenciar informações de empresas e clientes. A aplicação permite a criação, consulta e gerenciamento de dados através de uma API RESTful.
Essa aplicação foi idealizada para ser um servidor fictício Backend, ou seja, as contas e transações serão criadas a partir de requisições HTTP. Entretanto para permitir que a aplicação seja 100% funcional, seria apenas necessário implementar métodos de cybersegurança para uma transação segura e uma tela (Frontend) e conectar com o servidor. 
O login e cadastro de contas foram pensados para serem dados (json) gerados a partir das requisições. 

## Funcionalidades
- **Cadastro de Empresas:** Permite o cadastro de empresas com nome, CNPJ e saldo.
- **Cadastro de Clientes:** Permite o cadastro de clientes.
- **Consulta de Empresas:** Realiza consultas de empresas pelo CNPJ (para evitar expor dados de todas as empresas, cada empresa entraria com o seu CNPJ).
- **Consulta de Clientes:** Realiza consultas de clientes pelo CPF (para evitar expor dados de todos clientes, cada cliente entraria com o seu CPF).

## Arquitetura Básica:
![transacao4](https://github.com/user-attachments/assets/65e267a4-6b21-4c45-ac37-2721aa35a1ba)

## Como Executar
- **Tecnologias Necessárias:**
    É necessário ter o Java 8 (https://www.java.com/pt-BR/) baixado em seu computador e o JDK 22.0.2 (https://www.oracle.com/java/technologies/downloads/)
    Alguma IDE que rode Java, no caso do vscode com as extensões de java instaladas (Debugger for Java
v0.58.0)
    Algum programa que faça requisições HTTP, por exemplo o https://www.postman.com/

- **Envio de Email:** 
    Primeiro terá que entrar ou criar uma conta no site https://mailtrap.io/ para testar a conexão do email
    No canto esquerdo entrar na aba "Email Testing"
    No meio da tela clicar em "My inbox"
    Copiar as informações geradas no arquivo application.properties, assim como abaixo:
    
  
    spring.mail.host=sandbox.smtp.mailtrap.io
  
    spring.mail.port=587
  
    spring.mail.username= (seu username gerado no site)
  
    spring.mail.password= (sua senha gerada no site)
  
    spring.mail.properties.mail.sntp.auth=true
  
    spring.mail.properties.mail.sntp.starttls.enable=true
  
    Após isso o código estará pronto para mandar emails.
- **Rodar:** 
    Entrar no arquivo TransactionSystemApplication.java e rodá-lo 

- **Acessa a API** 
    Estão disponíveis os comandos GET e POST

    1. **Para iniciar uma Empresa**
    Já dentro do Postaman, colocar o método POST, para iniciar uma empresa com o seguinte endereço:
        localhost:8080/Company/setCompany
    Corpo da mensagem:
        ![transacao1](https://github.com/user-attachments/assets/59f6d331-f417-45a9-b482-271c4ece3782)
    Após isso colocar GET, com o seguinte endereço:
        localhost:8080/Company/getCompany/12345678000200 
    Note que o endereço final deve ser exatamente o cnpj da empresa já postada.

    Note também que deve ser apenas numeros.
  
    OBS: É possível realizar um POST com o mesmo corpo várias vezes, pois o conceito é ou criar uma conta, ou logar em uma, e o código utiliza o endereço para realizar os métodos.
  
    2. **Para iniciar uma Conta**
    Definir como POST
    Escrever o seguinte endereço:
        localhost:8080/Company/setClient
    No corpo da mensagem: 
        ![transacao2](https://github.com/user-attachments/assets/5f3273c1-857a-4d7b-92a8-7a4c6379db94)
    
    Após isso colocar GET, com o seguinte endereço: 
        localhost:8080/Company/getClient/12345678912
    Note que o endereço final deve ser exatamente o cpf da empresa já postada.
  
    Note também que deve ser apenas numeros.

    3. **Para iniciar uma Transação**
    Definir como POST
    Escrever o seguinte endereço: 
    localhost:8080/Transaction/postTransaction
    No corpo da mensagem:
        ![transacao3](https://github.com/user-attachments/assets/cc41daa3-1df0-4773-925b-5d14118446e1)
    Note que o valor é negativo, ou seja será um saque a partir da empresa registrada naquele CNPJ. 
    Para realizar um depósito é só colocar um valor positivo. 

    Com a criação da transação poderemos observar no site https://mailtrap.io/ que a transação foi realizada com sucesso a partir de um email enviado, registrado na transação. 

    Após isso mudar para GET
    Colocar o seguinte endereço para observar todas as transações realizadas nesse CNPJ:
        localhost:8080/Transaction/getTransaction/12345678000200
    
Sinta-se a vontade para contribuir com o código!
