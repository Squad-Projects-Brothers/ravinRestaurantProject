package main.controllers;

import main.models.Cliente;
import main.services.ClienteService;

import java.util.List;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController() {
        clienteService = new ClienteService();
    }

    public void salvarCliente(Cliente cliente) {
        clienteService.salvarCliente(cliente);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Cliente> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    public void excluirCliente(Cliente cliente) {
        clienteService.excluirCliente(cliente);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Cliente buscarClientePorId(int id) {
        return clienteService.buscarClientePorId(id);
    }
}
