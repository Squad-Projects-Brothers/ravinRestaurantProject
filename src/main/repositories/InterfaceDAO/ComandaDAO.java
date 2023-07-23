package main.repositories.InterfaceDAO;

import main.models.Comanda;

import java.util.List;

public interface ComandaDAO {
    void salvar(Comanda comanda);
    List<Comanda> listarTodos();
    void excluir(Comanda comanda);
    Comanda buscarPorId(int id);
}
