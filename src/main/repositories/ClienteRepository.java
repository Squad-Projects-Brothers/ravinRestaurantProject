package main.repositories;

import main.models.Cliente;
import main.models.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements ClienteDAO {
    @Override
    public void salvar(Cliente cliente) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO cliente (nome, cpf, telefone, data_nascimento, endereco_id, ativo, observacao) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getTelefone());
            statement.setDate(4, new Date(cliente.getDataNascimento().getTime()));
            statement.setInt(5, cliente.getEndereco().getId());
            statement.setBoolean(6, cliente.isAtivo());
            statement.setString(7, cliente.getObservacao());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                int enderecoId = resultSet.getInt("endereco_id");
                boolean ativo = resultSet.getBoolean("ativo");
                String observacao = resultSet.getString("observacao");

                Endereco endereco = buscarEnderecoPorId(enderecoId);

                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setTelefone(telefone);
                cliente.setDataNascimento(dataNascimento);
                cliente.setEndereco(endereco);
                cliente.setAtivo(ativo);
                cliente.setObservacao(observacao);

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public void excluir(Cliente cliente) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente WHERE id = ?")) {
            statement.setInt(1, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                int enderecoId = resultSet.getInt("endereco_id");
                boolean ativo = resultSet.getBoolean("ativo");
                String observacao = resultSet.getString("observacao");

                Endereco endereco = buscarEnderecoPorId(enderecoId);

                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setTelefone(telefone);
                cliente.setDataNascimento(dataNascimento);
                cliente.setEndereco(endereco);
                cliente.setAtivo(ativo);
                cliente.setObservacao(observacao);

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Endereco buscarEnderecoPorId(int id) {
        // Implement the logic to retrieve the Endereco object by its ID.
        // You can use the EnderecoRepository or any other mechanism for this.
        // For simplicity, let's assume it is already implemented elsewhere.
        // Here, we just return a dummy Endereco object.
        return new Endereco(id, "12345-678", "São Paulo", "SP", "Rua A", 123, "Bairro X", "Complemento Y");
    }
}
