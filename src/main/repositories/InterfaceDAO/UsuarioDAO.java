package main.repositories.InterfaceDAO;

import main.models.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void salvar(Usuario usuario);
    List<Usuario> listarTodos();
    void excluir(Usuario usuario);
    Usuario buscarPorId(int id);


}
