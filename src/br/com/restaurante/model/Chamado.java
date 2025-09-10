package br.com.restaurante.model;

public class Chamado {
    private int id;
    private String descricao;
    private String status; // ABERTO, EM_ATENDIMENTO, RESOLVIDO
    private int clienteId;
    private Integer atendenteId; // pode começar null

    public Chamado() {}

    public Chamado(String descricao, String status, int clienteId) {
        this.descricao = descricao;
        this.status = status;
        this.clienteId = clienteId;
    }

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public Integer getAtendenteId() { return atendenteId; }
    public void setAtendenteId(Integer atendenteId) { this.atendenteId = atendenteId; }

    @Override
    public String toString() {
        return "Chamado [id=" + id + ", descricao=" + descricao + ", status=" + status +
                ", clienteId=" + clienteId + ", atendenteId=" + atendenteId + "]";
    }
}