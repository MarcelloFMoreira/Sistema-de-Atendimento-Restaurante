package br.com.restaurante.dao;


import br.com.restaurante.model.Atendente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;;

public class AtendenteDAO {
    public void inserir(Atendente atendente) {
        String sql = "INSERT INTO atendente (id, nome, departamento) VALUES (seq_atendente.NEXTVAL, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, atendente.getNome());
            stmt.setString(2, atendente.getDepartamento());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Atendente> listar() {
        List<Atendente> lista = new ArrayList<>();
        String sql = "SELECT * FROM atendente";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Atendente a = new Atendente();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setDepartamento(rs.getString("departamento"));
                lista.add(a);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}


