package br.com.restaurante.dao;

import br.com.restaurante.exception.AtendimentoException;
import br.com.restaurante.model.Chamado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ChamadoDAO {

    public void inserir(Chamado chamado) throws AtendimentoException {
        String sql = "INSERT INTO chamado (id, descricao, status, cliente_id) VALUES (seq_chamado.NEXTVAL, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chamado.getDescricao());
            stmt.setString(2, chamado.getStatus());
            stmt.setInt(3, chamado.getClienteId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AtendimentoException("Erro ao abrir chamado!", e);
        }
    }

    public void resolverChamado(int chamadoId) throws AtendimentoException {
        String sql = "UPDATE chamado SET status='RESOLVIDO' WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, chamadoId);
            int atualizado = stmt.executeUpdate();
            if (atualizado == 0) {
                throw new AtendimentoException("Chamado não encontrado para resolução!");
            }
        } catch (SQLException e) {
            throw new AtendimentoException("Erro ao resolver chamado!", e);
        }
    }

    public List<Chamado> listar() throws AtendimentoException {
        List<Chamado> lista = new ArrayList<>();
        String sql = "SELECT * FROM chamado";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Chamado ch = new Chamado();
                ch.setId(rs.getInt("id"));
                ch.setDescricao(rs.getString("descricao"));
                ch.setStatus(rs.getString("status"));
                ch.setClienteId(rs.getInt("cliente_id"));

                // pode ser null se não foi atribuído
                int atendenteId = rs.getInt("atendente_id");
                if (!rs.wasNull()) {
                    ch.setAtendenteId(atendenteId);
                }

                lista.add(ch);
            }

        } catch (SQLException e) {
            throw new AtendimentoException("Erro ao listar chamados!", e);
        }
        return lista;
    }


    public void atribuirAtendente(int chamadoId, int atendenteId) throws AtendimentoException {
        String sql = "UPDATE chamado SET atendente_id=?, status='EM_ATENDIMENTO' WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, atendenteId);
            stmt.setInt(2, chamadoId);
            int atualizado = stmt.executeUpdate();

            if (atualizado == 0) {
                throw new AtendimentoException("Chamado não encontrado para atribuição!");
            }

        } catch (SQLException e) {
            throw new AtendimentoException("Erro ao atribuir chamado a atendente!", e);
        }
    }
}
