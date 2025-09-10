package br.com.restaurante.dao;

import br.com.restaurante.exception.AtendimentoException;
import br.com.restaurante.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

    public void inserir(Cliente cliente) throws AtendimentoException {
        String sql = "INSERT INTO cliente (id, nome, email, telefone) VALUES (seq_cliente.NEXTVAL, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new AtendimentoException("Erro ao inserir cliente!", e);
        }
    }

    public List<Cliente> listar() throws AtendimentoException {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new AtendimentoException("Erro ao listar clientes!", e);
        }
        return lista;
    }
}