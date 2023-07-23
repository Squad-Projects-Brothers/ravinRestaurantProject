package main.repositories;

import main.enums.TipoProdutoCardapio;
import main.models.Produto;
import main.repositories.InterfaceDAO.ProdutoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements ProdutoDAO {
  @Override
  public void salvar(Produto produto) {
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO produto (nome, descricao, codigo, preco_custo, preco_venda, " +
                "tempo_preparo, observacoes, tipo_produto, ativo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
      statement.setString(1, produto.getNome());
      statement.setString(2, produto.getDescricao());
      statement.setString(3, produto.getCodigo());
      statement.setDouble(4, produto.getPrecoCusto());
      statement.setDouble(5, produto.getPrecoVenda());
      statement.setString(6, produto.getTempoPreparo());
      statement.setString(7, produto.getObservacoes());
      statement.setString(8, produto.getTipoProduto().toString());
      statement.setBoolean(9, produto.isAtivo());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Produto> listarTodos() {
    List<Produto> produtos = new ArrayList<>();

    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto");
        ResultSet resultSet = statement.executeQuery()) {
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String descricao = resultSet.getString("descricao");
        String codigo = resultSet.getString("codigo");
        double precoCusto = resultSet.getDouble("preco_custo");
        double precoVenda = resultSet.getDouble("preco_venda");
        String tempoPreparo = resultSet.getString("tempo_preparo");
        String observacoes = resultSet.getString("observacoes");
        TipoProdutoCardapio tipoProduto = TipoProdutoCardapio.valueOf(resultSet.getString("tipo_produto"));
        boolean ativo = resultSet.getBoolean("ativo");

        Produto produto = new Produto(id, nome, descricao, codigo, precoCusto, precoVenda,
            tempoPreparo, observacoes, tipoProduto, ativo);
        produtos.add(produto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return produtos;
  }

  @Override
  public void excluir(Produto produto) {
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id = ?")) {
      statement.setInt(1, produto.getId());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Produto buscarPorId(int id) {
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto WHERE id = ?")) {
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        String nome = resultSet.getString("nome");
        String descricao = resultSet.getString("descricao");
        String codigo = resultSet.getString("codigo");
        double precoCusto = resultSet.getDouble("preco_custo");
        double precoVenda = resultSet.getDouble("preco_venda");
        String tempoPreparo = resultSet.getString("tempo_preparo");
        String observacoes = resultSet.getString("observacoes");
        TipoProdutoCardapio tipoProduto = TipoProdutoCardapio.valueOf(resultSet.getString("tipo_produto"));
        boolean ativo = resultSet.getBoolean("ativo");

        return new Produto(id, nome, descricao, codigo, precoCusto, precoVenda,
            tempoPreparo, observacoes, tipoProduto, ativo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }
}
