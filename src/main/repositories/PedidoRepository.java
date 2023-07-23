package main.repositories;

import main.models.Pedido;
import main.models.Produto;
import main.repositories.InterfaceDAO.PedidoDAO;
import main.enums.StatusPreparoPedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository implements PedidoDAO {
    @Override
    public void salvar(Pedido pedido) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO pedido (produto_id, data_hora_solicitacao, data_hora_inicio_preparo, tempo_preparo_restante, status_preparo, observacao, quantidade) "
                                +
                                "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setInt(1, pedido.getProduto().getId());
            statement.setTimestamp(2, pedido.getDataHoraSolicitacao());
            statement.setTimestamp(3, pedido.getDataHoraInicioPreparo());
            statement.setTimestamp(4, pedido.getTempoPreparoRestante());
            statement.setString(5, pedido.getStatusPreparo().toString());
            statement.setString(6, pedido.getObservacao());
            statement.setInt(7, pedido.getQuantidade());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pedido> listarTodos() {
        List<Pedido> pedidos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM pedido");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int produtoId = resultSet.getInt("produto_id");
                Timestamp dataHoraSolicitacao = resultSet.getTimestamp("data_hora_solicitacao");
                Timestamp dataHoraInicioPreparo = resultSet.getTimestamp("data_hora_inicio_preparo");
                Timestamp tempoPreparoRestante = resultSet.getTimestamp("tempo_preparo_restante");
                StatusPreparoPedido statusPreparo = StatusPreparoPedido.valueOf(resultSet.getString("status_preparo"));
                String observacao = resultSet.getString("observacao");
                int quantidade = resultSet.getInt("quantidade");

                Produto produto = buscarProdutoPorId(produtoId);

                Pedido pedido = new Pedido(id, produto, dataHoraSolicitacao, dataHoraInicioPreparo,
                        tempoPreparoRestante, statusPreparo, observacao, quantidade);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    @Override
    public void excluir(Pedido pedido) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM pedido WHERE id = ?")) {
            statement.setInt(1, pedido.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM pedido WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int produtoId = resultSet.getInt("produto_id");
                Timestamp dataHoraSolicitacao = resultSet.getTimestamp("data_hora_solicitacao");
                Timestamp dataHoraInicioPreparo = resultSet.getTimestamp("data_hora_inicio_preparo");
                Timestamp tempoPreparoRestante = resultSet.getTimestamp("tempo_preparo_restante");
                StatusPreparoPedido statusPreparo = StatusPreparoPedido.valueOf(resultSet.getString("status_preparo"));
                String observacao = resultSet.getString("observacao");
                int quantidade = resultSet.getInt("quantidade");

                Produto produto = buscarProdutoPorId(produtoId);

                return new Pedido(id, produto, dataHoraSolicitacao, dataHoraInicioPreparo, tempoPreparoRestante,
                        statusPreparo, observacao, quantidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Produto buscarProdutoPorId(int id) {
        ProdutoRepository produto = new ProdutoRepository();
        return produto.buscarPorId(id);
    }
}
