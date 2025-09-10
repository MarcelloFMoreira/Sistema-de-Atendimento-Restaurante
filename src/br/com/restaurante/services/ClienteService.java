package br.com.restaurante.services;

import br.com.restaurante.dao.ClienteDAO;
import br.com.restaurante.exception.AtendimentoException;
import br.com.restaurante.model.Cliente;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente(String nome, String email, String telefone) throws AtendimentoException {
        if (nome == null || nome.isBlank()) {
            throw new AtendimentoException("Nome do cliente não pode ser vazio");
        }
        if (email == null || !email.contains("@")) {
            throw new AtendimentoException("Email inválido");
        }
        clienteDAO.inserir(new Cliente(nome, email, telefone));
    }
}