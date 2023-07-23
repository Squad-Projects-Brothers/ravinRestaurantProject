package main.services;

import main.models.Usuario;
import main.repositories.UsuarioDAO;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void salvarUsuario(Usuario usuario) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        usuarioDAO.salvar(usuario);
    }

    public List<Usuario> listarTodosUsuario() {
        return usuarioDAO.listarTodos();
    }

    public void excluirUsuario(Usuario mesa) {
        usuarioDAO.excluir(mesa);
    }

    public Usuario buscarMesaPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

}
