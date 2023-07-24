package main.controllers;

import main.models.Usuario;
import main.services.UsuarioService;

import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        usuarioService = new UsuarioService();
    }

    public void salvarUsuario(Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.listarTodosUsuario();
    }

    public void excluirUsuario(Usuario usuario) {
        usuarioService.excluirUsuario(usuario);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarioService.buscarUsuarioPorId(id);
    }
}
