package main.models;

import main.enums.StatusPreparoPedido;

import java.sql.Timestamp;

public class Pedido {
  private int id;
  private Produto produto;
  private Comanda comanda;
  private Timestamp dataHoraSolicitacao;
  private Timestamp dataHoraInicioPreparo;
  private Timestamp tempoPreparoRestante;
  private StatusPreparoPedido statusPreparo;
  private String observacao;
  private int quantidade;

  public Pedido() {
  }

  @Override
  public String toString() {
    return "Pedido{" +
        "id=" + id +
        ", produto=" + produto +
        ", comanda=" + comanda +
        ", dataHoraSolicitacao=" + dataHoraSolicitacao +
        ", dataHoraInicioPreparo=" + dataHoraInicioPreparo +
        ", tempoPreparoRestante=" + tempoPreparoRestante +
        ", statusPreparo=" + statusPreparo +
        ", observacao='" + observacao + '\'' +
        ", quantidade=" + quantidade +
        '}';
  }

  public Pedido(int id, Produto produto, Comanda comanda, Timestamp dataHoraSolicitacao, Timestamp dataHoraInicioPreparo, Timestamp tempoPreparoRestante, StatusPreparoPedido statusPreparo, String observacao, int quantidade) {
    this.id = id;
    this.produto = produto;
    this.comanda = comanda;
    this.dataHoraSolicitacao = dataHoraSolicitacao;
    this.dataHoraInicioPreparo = dataHoraInicioPreparo;
    this.tempoPreparoRestante = tempoPreparoRestante;
    this.statusPreparo = statusPreparo;
    this.observacao = observacao;
    this.quantidade = quantidade;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Comanda getComanda() {
    return comanda;
  }

  public void setComanda(Comanda comanda) {
    this.comanda = comanda;
  }

  public Timestamp getDataHoraSolicitacao() {
    return dataHoraSolicitacao;
  }

  public void setDataHoraSolicitacao(Timestamp dataHoraSolicitacao) {
    this.dataHoraSolicitacao = dataHoraSolicitacao;
  }

  public Timestamp getDataHoraInicioPreparo() {
    return dataHoraInicioPreparo;
  }

  public void setDataHoraInicioPreparo(Timestamp dataHoraInicioPreparo) {
    this.dataHoraInicioPreparo = dataHoraInicioPreparo;
  }

  public Timestamp getTempoPreparoRestante() {
    return tempoPreparoRestante;
  }

  public void setTempoPreparoRestante(Timestamp tempoPreparoRestante) {
    this.tempoPreparoRestante = tempoPreparoRestante;
  }

  public StatusPreparoPedido getStatusPreparo() {
    return statusPreparo;
  }

  public void setStatusPreparo(StatusPreparoPedido statusPreparo) {
    this.statusPreparo = statusPreparo;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
}
