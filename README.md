# 🍽️ Sistema de Atendimento - Restaurante


## 📌 Visão Geral
O objetivo deste projeto é oferecer uma solução simples e organizada para o gerenciamento de **clientes, atendentes e chamados** em um restaurante.  
O sistema permite abrir chamados, atribuí-los a atendentes, resolver problemas e manter um histórico centralizado.

---

## ✅ Funcionalidades
- Cadastro de **Clientes** com validação de email.  
- Cadastro de **Atendentes**, organizados por departamento.  
- Gestão de **Chamados**, com fluxo completo de abertura, atribuição e resolução.  
- **Relatórios**: listagem de todos os chamados.  
- Tratamento de erros com **Exceções Customizadas** (`AtendimentoException`).  

---

## 🛠️ Tecnologias
- **Java 11+** – Linguagem principal  
- **Oracle Database** – Banco de dados relacional  
- **JDBC** – Conexão com o banco  
- **Padrões de Projeto** – DAO, Singleton, Service

---

## 🏗️ Arquitetura do Projeto

   ```bash
  src/
  ├── main/
  │   └── java/
  │       └── br/
  │           └── com/
  │               └── restaurante/
  │                   └── atendimento/
  │                       ├── model/          # Entidades
  │                       ├── dao/            # Acesso a dados
  │                       ├── service/        # Regras de negócio
  │                       ├── exception/      # Tratamento de erros
  │                       └── Main.java       # Aplicação principal

```
# Pré-requisitos
- Java JDK 11+
- Oracle Database
- Driver JDBC Oracle

---

# ▶️ Como executar 

1. Clone o repositório:
   ```bash
   git clone https://github.com/MarcelloFMoreira/Sistema-de-Atendimento-Restaurante.git
   cd sistema-atendimento
   ```
   
2. Configure o ConnectionFactory com usuário, senha e URL do seu banco Oracle:
   ```bash
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
   private static final String USER = "usuario";
   private static final String PASSWORD = "senha";
   ```
   
3. Caso não tenha faça o download do driver JDBC
   - https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html

4. Adicione o jar ao seu projeto no IntelliJ
   - Clique com botão direito no projeto → Open Module Settings
   - Vá em Libraries + Java
   - Selecione o arquivo ojdbc.jar baixado
   - Clique em OK

5. Compile e execute a aplicação:
   ```bash
   javac Main.java
   java Main
   ```
   
---

## Autor
Desenvolvido por Marcello de Freitas Moreira - RM557531 e Guilherme flores pereira de almeida RM554948

---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**.

