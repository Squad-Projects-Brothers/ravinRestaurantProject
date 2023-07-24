package main.models;

import java.util.List;

public class Cardapio {

  private int id;
  private String nome;
  private List<Produto> produtos;

  @Override
  public String toString() {
    return "Cardapio{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", produtos=" + produtos +
        '}';
  }

  public Cardapio() {
  }

  public Cardapio(int id, String nome, List<Produto> produtos) {
    this.id = id;
    this.nome = nome;
    this.produtos = produtos;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}
