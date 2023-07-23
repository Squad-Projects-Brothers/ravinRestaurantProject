package main.services;

import main.models.Endereco;
import main.repositories.EnderecoRepository;
import main.repositories.InterfaceDAO.EnderecoDAO;

import java.util.List;

public class EnderecoService {

    private EnderecoDAO enderecoDAO;

    public EnderecoService() {
        this.enderecoDAO = new EnderecoRepository();
    }

    public void salvarEndereco(Endereco endereco) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        enderecoDAO.salvar(endereco);
    }

    public List<Endereco> listarTodosEndereco() {
        return enderecoDAO.listarTodos();
    }

    public void excluirEndereco(Endereco endereco) {
        enderecoDAO.excluir(endereco);
    }

    public Endereco buscarEnderecoPorId(int id) {
        return enderecoDAO.buscarPorId(id);
    }


}
