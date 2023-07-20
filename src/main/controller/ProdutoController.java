package main.controller;

import main.models.Produto;
import main.services.ProdutoService;

import java.util.List;


public class ProdutoController {
  private ProdutoService produtoService;

  public ProdutoController() {
    produtoService = new ProdutoService();
  }

  public void salvarProduto(Produto produto) {
    produtoService.salvarProduto(produto);
    // Retornar a resposta apropriada ao front-end, se necessário
  }

  public List<Produto> listarTodosProdutos() {
    return produtoService.listarTodosProdutos();
  }

  public void excluirProduto(Produto produto) {
    produtoService.excluirProduto(produto);
    // Retornar a resposta apropriada ao front-end, se necessário
  }

  public Produto buscarProdutoPorId(int id) {
    return produtoService.buscarProdutoPorId(id);
  }
}
