package br.com.restaurante.services;

import br.com.restaurante.dao.ChamadoDAO;
import br.com.restaurante.exception.AtendimentoException;
import br.com.restaurante.model.Chamado;

import java.util.List;

public class ChamadoService {
    private ChamadoDAO chamadoDAO;

    public ChamadoService() {
        this.chamadoDAO = new ChamadoDAO();
    }

    public void abrirChamado(String descricao, int idCliente) throws AtendimentoException {
        if (descricao == null || descricao.isBlank()) {
            throw new AtendimentoException("Descrição do chamado não pode ser vazia");
        }
        chamadoDAO.inserir(new Chamado(descricao, "ABERTO", idCliente));
    }

    public List<Chamado> listarChamados() throws AtendimentoException {
        return chamadoDAO.listar();
    }

    public void atribuirChamado(int idChamado, int idAtendente) throws AtendimentoException {
        chamadoDAO.atribuirAtendente(idChamado, idAtendente);
    }

    public void resolverChamado(int idChamado) throws AtendimentoException {
        chamadoDAO.resolverChamado(idChamado);
    }
}