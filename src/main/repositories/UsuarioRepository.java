package main.repositories;

import main.enums.TipoUsuario;
import main.models.Usuario;
import main.repositories.InterfaceDAO.UsuarioDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements UsuarioDAO {
    @Override
    public void salvar(Usuario usuario) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO usuario (nome, login, senha, tipo_usuario, ativo, logado, criado_por, criado_em, alterado_por, alterado_em) "
                                +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getTipoUsuario().toString());
            statement.setBoolean(5, usuario.isAtivo());
            statement.setBoolean(6, usuario.isLogado());
            statement.setString(7, usuario.getCriadoPor());
            statement.setDate(8, Date.valueOf(usuario.getCriadoEm()));
            statement.setString(9, usuario.getAlteradoPor());
            statement.setDate(10, Date.valueOf(usuario.getAlteradoEm()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipo_usuario"));
                boolean ativo = resultSet.getBoolean("ativo");
                boolean logado = resultSet.getBoolean("logado");
                String criadoPor = resultSet.getString("criado_por");
                LocalDate criadoEm = resultSet.getDate("criado_em").toLocalDate();
                String alteradoPor = resultSet.getString("alterado_por");
                LocalDate alteradoEm = resultSet.getDate("alterado_em").toLocalDate();

                Usuario usuario = new Usuario(id, nome, login, senha, tipoUsuario, ativo, logado, criadoPor, criadoEm,
                        alteradoPor, alteradoEm);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public void excluir(Usuario usuario) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?")) {
            statement.setInt(1, usuario.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscarPorId(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultSet.getString("tipo_usuario"));
                boolean ativo = resultSet.getBoolean("ativo");
                boolean logado = resultSet.getBoolean("logado");
                String criadoPor = resultSet.getString("criado_por");
                LocalDate criadoEm = resultSet.getDate("criado_em").toLocalDate();
                String alteradoPor = resultSet.getString("alterado_por");
                LocalDate alteradoEm = resultSet.getDate("alterado_em").toLocalDate();

                return new Usuario(id, nome, login, senha, tipoUsuario, ativo, logado, criadoPor, criadoEm, alteradoPor,
                        alteradoEm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
