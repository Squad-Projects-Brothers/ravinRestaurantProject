package main.repositories.InterfaceDAO;

import main.models.Endereco;

import java.util.List;

public interface EnderecoDAO {
    void salvar(Endereco endereco);
    List<Endereco> listarTodos();
    void excluir(Endereco endereco);
    Endereco buscarPorId(int id);
}
