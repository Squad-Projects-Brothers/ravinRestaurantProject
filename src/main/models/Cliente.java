package main.models;

import java.util.Date;

public class Cliente extends Pessoa {

    private int id;
    private String observacao;

    @Override
    public String toString() {
        return "Cliente{" +
            "id=" + id +
            ", observacao='" + observacao + '\'' +
            '}';
    }

    public Cliente(){
    }
    public Cliente(int id, String nome, String cpf, String telefone, Date dataNascimento, Endereco endereco, boolean ativo, int id1, String observacao) {
        super(id, nome, cpf, telefone, dataNascimento, endereco, ativo);
        this.id = id;
        this.observacao = observacao;
    }

    public Cliente(int id, String observacao) {
        this.id = id;
        this.observacao = observacao;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
