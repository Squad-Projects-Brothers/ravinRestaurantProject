package main.repositories;

import main.enums.TipoProdutoCardapio;
import main.models.Cardapio;
import main.models.Produto;
import main.repositories.InterfaceDAO.CardapioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardapioRepository implements CardapioDAO {
    @Override
    public void salvar(Cardapio cardapio) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO cardapio (nome) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cardapio.getNome());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int cardapioId = generatedKeys.getInt(1);
                for (Produto produto : cardapio.getProdutos()) {
                    associarProdutoAoCardapio(cardapioId, produto.getId());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void associarProdutoAoCardapio(int cardapioId, int produtoId) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO cardapio_produto (cardapio_id, produto_id) VALUES (?, ?)")) {
            statement.setInt(1, cardapioId);
            statement.setInt(2, produtoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cardapio> listarTodos() {
        List<Cardapio> cardapios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cardapio");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                List<Produto> produtos = buscarProdutosPorCardapioId(id);

                Cardapio cardapio = new Cardapio(id, nome, produtos);
                cardapios.add(cardapio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cardapios;
    }

    @Override
    public void excluir(Cardapio cardapio) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM cardapio WHERE id = ?")) {
            statement.setInt(1, cardapio.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cardapio buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM cardapio WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");

                List<Produto> produtos = buscarProdutosPorCardapioId(id);

                return new Cardapio(id, nome, produtos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Produto> buscarProdutosPorCardapioId(int cardapioId) {
        List<Produto> produtos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT p.* FROM produto p " +
                                "JOIN cardapio_produto cp ON p.id = cp.produto_id " +
                                "WHERE cp.cardapio_id = ?")) {
            statement.setInt(1, cardapioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int produtoId = resultSet.getInt("id");
                Produto produto = buscarProdutoPorId(produtoId);
                if (produto != null) {
                    produtos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    private Produto buscarProdutoPorId(int id) {
        ProdutoRepository produtoRepository = new ProdutoRepository();
        return produtoRepository.buscarPorId(id);
    }
}
