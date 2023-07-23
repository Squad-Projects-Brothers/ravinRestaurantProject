package main.repositories.InterfaceDAO;

import main.models.Produto;

import java.util.List;

public interface ProdutoDAO {
  void salvar(Produto produto);
  List<Produto> listarTodos();
  void excluir(Produto produto);
  Produto buscarPorId(int id);
}

