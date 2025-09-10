package br.com.restaurante.services;

import br.com.restaurante.dao.AtendenteDAO;
import br.com.restaurante.exception.AtendimentoException;
import br.com.restaurante.model.Atendente;

public class AtendenteService {
    private AtendenteDAO atendenteDAO;

    public AtendenteService() {
        this.atendenteDAO = new AtendenteDAO();
    }

    public void cadastrarAtendente(String nome, String departamento) throws AtendimentoException {
        if (nome == null || nome.isBlank()) {
            throw new AtendimentoException("Nome do atendente nÃ£o pode ser vazio");
        }
        atendenteDAO.inserir(new Atendente(nome, departamento));
    }
}