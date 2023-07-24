package main.controllers;

import main.models.Funcionario;
import main.services.FuncionarioService;

import java.util.List;

public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController() {
        funcionarioService = new FuncionarioService();
    }

    public void salvarFuncionario(Funcionario funcionario) {
        funcionarioService.salvarFuncionario(funcionario);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioService.listarTodosFuncionario();
    }

    public void excluirFuncionario(Funcionario funcionario) {
        funcionarioService.excluirFuncionario(funcionario);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioService.buscarFuncionarioPorId(id);
    }
}
