package main.repositories;

import main.models.Cardapio;

import java.util.List;

public interface CardapioDAO {
    void salvar(Cardapio cardapio);
    List<Cardapio> listarTodos();
    void excluir(Cardapio cardapio);
    Cardapio buscarPorId(int id);
}
