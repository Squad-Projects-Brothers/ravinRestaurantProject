package main.repositories;

import main.enums.Cargo;
import main.enums.Escolaridade;
import main.enums.EstadoCivil;
import main.models.Endereco;
import main.models.Funcionario;
import main.repositories.InterfaceDAO.FuncionarioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionarioRepository implements FuncionarioDAO {
    private EnderecoRepository enderecoRepository;

    public FuncionarioRepository() {
        enderecoRepository = new EnderecoRepository();
    }

    @Override
    public void salvar(Funcionario funcionario) {
        enderecoRepository.salvar(funcionario.getEndereco());

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO funcionario (nome, cpf, telefone, data_nascimento, rg, estado_civil, escolaridade, cargo, numero_carteira_trabalho, data_admissao, data_demissao, disponivel, ativo, endereco_id) "
                                +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setString(3, funcionario.getTelefone());
            statement.setDate(4, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            statement.setString(5, funcionario.getRg());
            statement.setString(6, funcionario.getEstadoCivil().toString());
            statement.setString(7, funcionario.getEscolaridade().toString());
            statement.setString(8, funcionario.getCargo().toString());
            statement.setString(9, funcionario.getNumeroCarteiraTrabalho());
            statement.setDate(10, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
            if (funcionario.getDataDemissao() != null) {
                statement.setDate(11, new java.sql.Date(funcionario.getDataDemissao().getTime()));
            } else {
                statement.setNull(11, Types.DATE);
            }
            statement.setBoolean(12, funcionario.isDisponivel());
            statement.setBoolean(13, funcionario.isAtivo());
            statement.setInt(14, funcionario.getEndereco().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM funcionario " +
                        "JOIN endereco ON funcionario.endereco_id = endereco.id");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("funcionario.id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String rg = resultSet.getString("rg");
                EstadoCivil estadoCivil = EstadoCivil.valueOf(resultSet.getString("estado_civil"));
                Escolaridade escolaridade = Escolaridade.valueOf(resultSet.getString("escolaridade"));
                Cargo cargo = Cargo.valueOf(resultSet.getString("cargo"));
                String numeroCarteiraTrabalho = resultSet.getString("numero_carteira_trabalho");
                Date dataAdmissao = resultSet.getDate("data_admissao");
                Date dataDemissao = resultSet.getDate("data_demissao");
                boolean disponivel = resultSet.getBoolean("disponivel");
                boolean ativo = resultSet.getBoolean("ativo");

                int enderecoId = resultSet.getInt("endereco.id");
                String cep = resultSet.getString("cep");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                String complemento = resultSet.getString("complemento");

                Endereco endereco = new Endereco(enderecoId, cep, cidade, estado, rua, numero, bairro, complemento);
                Funcionario funcionario = new Funcionario(id, nome, cpf, telefone, dataNascimento, endereco, ativo,
                        id, rg, estadoCivil, escolaridade, cargo, numeroCarteiraTrabalho, dataAdmissao, dataDemissao,
                        disponivel);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    @Override
    public void excluir(Funcionario funcionario) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM funcionario WHERE id = ?")) {
            statement.setInt(1, funcionario.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM funcionario " +
                        "JOIN endereco ON funcionario.endereco_id = endereco.id " +
                        "WHERE funcionario.id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                Date dataNascimento = resultSet.getDate("data_nascimento");
                String rg = resultSet.getString("rg");
                EstadoCivil estadoCivil = EstadoCivil.valueOf(resultSet.getString("estado_civil"));
                Escolaridade escolaridade = Escolaridade.valueOf(resultSet.getString("escolaridade"));
                Cargo cargo = Cargo.valueOf(resultSet.getString("cargo"));
                String numeroCarteiraTrabalho = resultSet.getString("numero_carteira_trabalho");
                Date dataAdmissao = resultSet.getDate("data_admissao");
                Date dataDemissao = resultSet.getDate("data_demissao");
                boolean disponivel = resultSet.getBoolean("disponivel");
                boolean ativo = resultSet.getBoolean("ativo");

                int enderecoId = resultSet.getInt("endereco.id");
                String cep = resultSet.getString("cep");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                String rua = resultSet.getString("rua");
                int numero = resultSet.getInt("numero");
                String bairro = resultSet.getString("bairro");
                String complemento = resultSet.getString("complemento");

                Endereco endereco = new Endereco(enderecoId, cep, cidade, estado, rua, numero, bairro, complemento);
                return new Funcionario(id, nome, cpf, telefone, dataNascimento, endereco, ativo,
                        id, rg, estadoCivil, escolaridade, cargo, numeroCarteiraTrabalho, dataAdmissao, dataDemissao,
                        disponivel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
