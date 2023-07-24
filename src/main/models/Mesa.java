package main.models;

import main.enums.StatusMesa;

public class Mesa {

    private int id;
    //private Funcionario funcionario; --> ESSE EU ACREDITO QUE É MELHOR GERIR À COMANDA OU O PEDIDO
    private String codigo;
    private int numero;
    private StatusMesa statusMesa;
    private int capacidade;

    public Mesa(){};

    @Override
    public String toString() {
        return "Mesa{" +
            "id=" + id +
            ", codigo='" + codigo + '\'' +
            ", numero=" + numero +
            ", statusMesa=" + statusMesa +
            ", capacidade=" + capacidade +
            '}';
    }

    public Mesa(int id, String codigo, int numero, StatusMesa statusMesa, int capacidade) {
        this.id = id;
        this.codigo = codigo;
        this.numero = numero;
        this.statusMesa = statusMesa;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
