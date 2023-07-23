package main.repositories.InterfaceDAO;

import java.util.List;

import main.models.Funcionario;

public interface FuncionarioDAO {
    void salvar(Funcionario funcionario);

    List<Funcionario> listarTodos();

    void excluir(Funcionario funcionario);

    Funcionario buscarPorId(int id);
}
