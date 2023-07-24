package main.repositories;

import main.models.Comanda;
import main.models.Mesa;
import main.models.Pedido;
import main.repositories.InterfaceDAO.ComandaDAO;
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
                             "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, comanda.getMesa().getId());
            statement.setString(2, comanda.getCodigo());
            statement.setString(3, comanda.getObservacoes());
            statement.setString(4, comanda.getStatusComanda().toString());
            statement.setDouble(5, comanda.getValorTotal());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int comandaId = resultSet.getInt(1);
                comanda.setId(comandaId);

                // Salvar os pedidos associados à comanda no banco de dados
                PedidoRepository pedidoRepository = new PedidoRepository();
                for (Pedido pedido : comanda.getPedidos()) {
                    pedido.setComanda(comanda);
                    pedidoRepository.salvar(pedido);
                }
            }
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
        MesaRepository mesaRepository = new MesaRepository();
        return mesaRepository.buscarPorId(id);
    }

    private List<Pedido> buscarPedidosPorComandaId(int comandaId) {
        PedidoRepository pedidoRepository = new PedidoRepository();
        return (List<Pedido>) pedidoRepository.buscarPorId(comandaId);
    }
}
