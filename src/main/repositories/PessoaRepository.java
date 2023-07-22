package main.repositories;

import main.models.Pessoa;
import main.models.Endereco;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaRepository implements PessoaDAO {
    @Override
    public void salvar(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO pessoa (nome, cpf, telefone, data_nascimento, endereco, ativo) " +
                             "VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getCpf());
            statement.setString(3, pessoa.getTelefone());
            statement.setDate(4, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            statement.setString(5, pessoa.getEndereco().toString());
            statement.setBoolean(6, pessoa.isAtivo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pessoa> listarTodos() {
        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM pessoa");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String enderecoStr = resultSet.getString("endereco");
                boolean ativo = resultSet.getBoolean("ativo");

                String[] enderecoComponents = enderecoStr.split(", ");
                String cep = enderecoComponents[0];
                String cidade = enderecoComponents[1];
                String estado = enderecoComponents[2];
                String rua = enderecoComponents[3];
                int numero = Integer.parseInt(enderecoComponents[4]);
                String bairro = enderecoComponents[5];
                String complemento = enderecoComponents[6];

                Endereco endereco = new Endereco(id, cep, cidade, estado, rua, numero, bairro, complemento);

                Pessoa pessoa = new Pessoa(id, nome, cpf, telefone, dataNascimento, endereco, ativo);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    @Override
    public void excluir(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM pessoa WHERE id = ?")) {
            statement.setInt(1, pessoa.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pessoa buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM pessoa WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String enderecoStr = resultSet.getString("endereco");
                boolean ativo = resultSet.getBoolean("ativo");

                String[] enderecoComponents = enderecoStr.split(", ");
                String cep = enderecoComponents[0];
                String cidade = enderecoComponents[1];
                String estado = enderecoComponents[2];
                String rua = enderecoComponents[3];
                int numero = Integer.parseInt(enderecoComponents[4]);
                String bairro = enderecoComponents[5];
                String complemento = enderecoComponents[6];

                Endereco endereco = new Endereco(id, cep, cidade, estado, rua, numero, bairro, complemento);

                return new Pessoa(id, nome, cpf, telefone, dataNascimento, endereco, ativo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
