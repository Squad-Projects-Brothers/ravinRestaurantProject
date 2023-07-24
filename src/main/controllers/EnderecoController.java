package main.controllers;

import main.models.Endereco;
import main.services.EnderecoService;

import java.util.List;

public class EnderecoController {
    private EnderecoService enderecoService;

    public EnderecoController() {
        enderecoService = new EnderecoService();
    }

    public void salvarEndereco(Endereco endereco) {
        enderecoService.salvarEndereco(endereco);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Endereco> listarTodosEnderecos() {
        return enderecoService.listarTodosEndereco();
    }

    public void excluirEndereco(Endereco endereco) {
        enderecoService.excluirEndereco(endereco);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Endereco buscarEnderecoPorId(int id) {
        return enderecoService.buscarEnderecoPorId(id);
    }
}
