package main.repositories;

import java.util.List;

import main.models.Pessoa;

public interface PessoaDAO {
    void salvar(Pessoa pessoa);

    List<Pessoa> listarTodos();

    void excluir(Pessoa pessoa);

    Pessoa buscarPorId(int id);
}
