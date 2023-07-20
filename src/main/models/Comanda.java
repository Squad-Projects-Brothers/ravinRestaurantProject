package main.models;

import main.enums.StatusComanda;

import java.util.List;

public class Comanda {
  private int id;
  private int mesa;
  private List<Pedido> pedidos;
  private String codigo;
  private String observacoes;
  private StatusComanda statusComanda;

  public Comanda() {
  }

  public Comanda(int id, int mesa, List<Pedido> pedidos, String codigo, String observacoes, StatusComanda statusComanda) {
    this.id = id;
    this.mesa = mesa;
    this.pedidos = pedidos;
    this.codigo = codigo;
    this.observacoes = observacoes;
    this.statusComanda = statusComanda;
  }
}
