package main.services;

import main.models.Cliente;
import main.repositories.ClienteDAO;

import java.util.List;

public class ClienteService {

    private ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void salvarCliente(Cliente cliente) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        clienteDAO.salvar(cliente);
    }

    public List<Cliente> listarTodosClientes() {
        return clienteDAO.listarTodos();
    }

    public void excluirCliente(Cliente cliente) {
        clienteDAO.excluir(cliente);
    }

    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarPorId(id);
    }

}
