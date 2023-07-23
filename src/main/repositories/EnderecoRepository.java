package main.repositories;

import main.models.Endereco;
import main.repositories.InterfaceDAO.EnderecoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository implements EnderecoDAO {
    @Override
    public void salvar(Endereco endereco) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO endereco (cep, cidade, estado, rua, numero, bairro, complemento) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, endereco.getCep());
            statement.setString(2, endereco.getCidade());
            statement.setString(3, endereco.getEstado());
            statement.setString(4, endereco.getRua());
            statement.setInt(5, endereco.getNumero());
            statement.setString(6, endereco.getBairro());
            statement.setString(7, endereco.getComplemento());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Endereco> listarTodos() {
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM endereco");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cep = resultSet.getString("cep");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                String complemento = resultSet.getString("complemento");

                Endereco endereco = new Endereco(id, cep, cidade, estado, rua, numero, bairro, complemento);
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enderecos;
    }

    @Override
    public void excluir(Endereco endereco) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM endereco WHERE id = ?")) {
            statement.setInt(1, endereco.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Endereco buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM endereco WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cep = resultSet.getString("cep");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                String complemento = resultSet.getString("complemento");

                return new Endereco(id, cep, cidade, estado, rua, numero, bairro, complemento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
