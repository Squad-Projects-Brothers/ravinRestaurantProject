package main.models;

public class Cliente extends Pessoa {

    private int id;
    private String observacao;

    public Cliente(){
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
