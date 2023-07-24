package main.services;

import main.models.Usuario;
import main.repositories.InterfaceDAO.UsuarioDAO;
import main.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioRepository();
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

    public Usuario buscarUsuarioPorId(int id) {
        return usuarioDAO.buscarPorId(id);
    }

}
