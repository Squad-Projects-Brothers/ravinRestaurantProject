package main.repositories;

import main.models.Mesa;

import java.util.List;

public interface MesaDAO {
    void salvar(Mesa mesa);
    List<Mesa> listarTodos();
    void excluir(Mesa mesa);
    Mesa buscarPorId(int id);
}
