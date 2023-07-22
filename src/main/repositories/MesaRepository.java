package main.repositories;

import main.models.Mesa;
import main.enums.StatusMesa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesaRepository implements MesaDAO {
    @Override
    public void salvar(Mesa mesa) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO mesa (codigo, numero, status_mesa, capacidade) " +
                             "VALUES (?, ?, ?, ?)")) {
            statement.setString(1, mesa.getCodigo());
            statement.setInt(2, mesa.getNumero());
            statement.setString(3, mesa.getStatusMesa().toString());
            statement.setInt(4, mesa.getCapacidade());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Mesa> listarTodos() {
        List<Mesa> mesas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM mesa");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String codigo = resultSet.getString("codigo");
                int numero = resultSet.getInt("numero");
                StatusMesa statusMesa = StatusMesa.valueOf(resultSet.getString("status_mesa"));
                int capacidade = resultSet.getInt("capacidade");

                Mesa mesa = new Mesa(id, codigo, numero, statusMesa, capacidade);
                mesas.add(mesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mesas;
    }

    @Override
    public void excluir(Mesa mesa) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM mesa WHERE id = ?")) {
            statement.setInt(1, mesa.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mesa buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM mesa WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                int numero = resultSet.getInt("numero");
                StatusMesa statusMesa = StatusMesa.valueOf(resultSet.getString("status_mesa"));
                int capacidade = resultSet.getInt("capacidade");

                return new Mesa(id, codigo, numero, statusMesa, capacidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
