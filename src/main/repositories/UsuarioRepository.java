package main.repositories;

import main.enums.TipoProdutoCardapio;
import main.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository implements UsuarioDAO {

    @Override
    public void salvar(Usuario usuario) {

    }

    @Override
    public List<Usuario> listarTodos() {
        return null;
    }

    @Override
    public void excluir(Usuario usuario) {

    }

    @Override
    public Usuario buscarPorId(int id) {
        return null;
    }
}
