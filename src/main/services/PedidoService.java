package main.services;

import main.models.Pedido;
import main.repositories.InterfaceDAO.PedidoDAO;
import main.repositories.PedidoRepository;

import java.util.List;

public class PedidoService {

    private PedidoDAO pedidoDAO;

    public PedidoService() {
        this.pedidoDAO = new PedidoRepository();
    }

    public void salvarPedido(Pedido pedido) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        pedidoDAO.salvar(pedido);
    }

    public List<Pedido> listarTodosPedido() {
        return pedidoDAO.listarTodos();
    }

    public void excluirPedido(Pedido mesa) {
        pedidoDAO.excluir(mesa);
    }

    public Pedido buscarPedidoPorId(int id) {
        return pedidoDAO.buscarPorId(id);
    }

}
