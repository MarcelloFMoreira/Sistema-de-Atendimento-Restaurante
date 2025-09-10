package br.com.restaurante.model;


public class Atendente {
    private int id;
    private String nome;
    private String departamento;

    public Atendente() {}

    public Atendente(String nome, String departamento) {
        this.nome = nome;
        this.departamento = departamento;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    @Override
    public String toString() {
        return "Atendente [id=" + id + ", nome=" + nome + ", departamento=" + departamento + "]";
    }
}