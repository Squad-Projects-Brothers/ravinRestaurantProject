package main.services;

import main.models.Endereco;
import main.models.Funcionario;
import main.repositories.EnderecoRepository;
import main.repositories.FuncionarioRepository;
import main.repositories.InterfaceDAO.FuncionarioDAO;

import java.util.List;

public class FuncionarioService {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioService() {
        this.funcionarioDAO = new FuncionarioRepository();
    }

    public void salvarFuncionario(Funcionario funcionario) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        funcionarioDAO.salvar(funcionario);
    }

    public List<Funcionario> listarTodosFuncionario() {
        return funcionarioDAO.listarTodos();
    }

    public void excluirFuncionario(Funcionario funcionario) {
        funcionarioDAO.excluir(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioDAO.buscarPorId(id);
    }
}
