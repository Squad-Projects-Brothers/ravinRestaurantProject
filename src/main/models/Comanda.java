package main.models;

import main.enums.StatusComanda;

import java.util.List;

public class Comanda {
  private int id;
  private Mesa mesa;
  private List<Pedido> pedidos;
  private String codigo;
  private String observacoes;
  private StatusComanda statusComanda;

  private double valorTotal;

  public Comanda() {
  }

  public Comanda(int id, Mesa mesa, List<Pedido> pedidos, String codigo, String observacoes, StatusComanda statusComanda,
                 double valorTotal) {
    this.id = id;
    this.mesa = mesa;
    this.pedidos = pedidos;
    this.codigo = codigo;
    this.observacoes = observacoes;
    this.statusComanda = statusComanda;
    this.valorTotal = valorTotal;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Mesa getMesa() {
    return mesa;
  }

  public void setMesa(Mesa mesa) {
    this.mesa = mesa;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public StatusComanda getStatusComanda() {
    return statusComanda;
  }

  public void setStatusComanda(StatusComanda statusComanda) {
    this.statusComanda = statusComanda;
  }

  public double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

}
