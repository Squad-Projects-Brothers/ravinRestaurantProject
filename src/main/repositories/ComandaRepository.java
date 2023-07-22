package main.repositories;

import main.models.Comanda;
import main.models.Mesa;
import main.models.Pedido;
import main.enums.StatusComanda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaRepository implements ComandaDAO {
    @Override
    public void salvar(Comanda comanda) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO comanda (mesa_id, codigo, observacoes, status_comanda, valor_total) " +
                             "VALUES (?, ?, ?, ?, ?)")) {
            statement.setInt(1, comanda.getMesa().getId());
            statement.setString(2, comanda.getCodigo());
            statement.setString(3, comanda.getObservacoes());
            statement.setString(4, comanda.getStatusComanda().toString());
            statement.setDouble(5, comanda.getValorTotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comanda> listarTodos() {
        List<Comanda> comandas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM comanda");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int mesaId = resultSet.getInt("mesa_id");
                String codigo = resultSet.getString("codigo");
                String observacoes = resultSet.getString("observacoes");
                StatusComanda statusComanda = StatusComanda.valueOf(resultSet.getString("status_comanda"));
                double valorTotal = resultSet.getDouble("valor_total");

                Mesa mesa = buscarMesaPorId(mesaId);
                List<Pedido> pedidos = buscarPedidosPorComandaId(id);

                Comanda comanda = new Comanda(id, mesa, pedidos, codigo, observacoes, statusComanda, valorTotal);
                comandas.add(comanda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comandas;
    }

    @Override
    public void excluir(Comanda comanda) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM comanda WHERE id = ?")) {
            statement.setInt(1, comanda.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Comanda buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM comanda WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int mesaId = resultSet.getInt("mesa_id");
                String codigo = resultSet.getString("codigo");
                String observacoes = resultSet.getString("observacoes");
                StatusComanda statusComanda = StatusComanda.valueOf(resultSet.getString("status_comanda"));
                double valorTotal = resultSet.getDouble("valor_total");

                Mesa mesa = buscarMesaPorId(mesaId);
                List<Pedido> pedidos = buscarPedidosPorComandaId(id);

                return new Comanda(id, mesa, pedidos, codigo, observacoes, statusComanda, valorTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Mesa buscarMesaPorId(int id) {
        // Implement the logic to retrieve the Mesa object by its ID.
        // You can use the MesaRepository or any other mechanism for this.
        // For simplicity, let's assume it is already implemented elsewhere.
        // Here, we just return a dummy Mesa object.
        return new Mesa(id, "COD-001", 1, null, 4);
    }

    private List<Pedido> buscarPedidosPorComandaId(int comandaId) {
        // Implement the logic to retrieve a list of Pedido objects by the comandaId.
        // You can use the PedidoRepository or any other mechanism for this.
        // For simplicity, let's assume it is already implemented elsewhere.
        // Here, we just return a dummy list of Pedido objects.
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(1, null, null, null, null, null, null, 0));
        return pedidos;
    }
}
