package main.services;

import java.util.List;
import main.repositories.ProdutoDAO;
import main.repositories.ProdutoRepository;
import main.models.Produto;

public class ProdutoService {
  private ProdutoDAO produtoDAO;

  public ProdutoService() {
    produtoDAO = new ProdutoRepository();
  }

  public void salvarProduto(Produto produto) {
    // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
    produtoDAO.salvar(produto);
  }

  public List<Produto> listarTodosProdutos() {
    return produtoDAO.listarTodos();
  }

  public void excluirProduto(Produto produto) {
    produtoDAO.excluir(produto);
  }

  public Produto buscarProdutoPorId(int id) {
    return produtoDAO.buscarPorId(id);
  }
}
