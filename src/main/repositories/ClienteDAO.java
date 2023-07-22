package main.repositories;

import main.models.Cliente;

import java.util.List;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    List<Cliente> listarTodos();
    void excluir(Cliente cliente);
    Cliente buscarPorId(int id);
}
