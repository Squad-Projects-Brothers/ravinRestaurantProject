package main.controllers;

import main.models.Pedido;
import main.services.PedidoService;

import java.util.List;

public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController() {
        pedidoService = new PedidoService();
    }

    public void salvarPedido(Pedido pedido) {
        pedidoService.salvarPedido(pedido);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Pedido> listarTodosPedidos() {
        return pedidoService.listarTodosPedido();
    }

    public void excluirPedido(Pedido pedido) {
        pedidoService.excluirPedido(pedido);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Pedido buscarPedidoPorId(int id) {
        return pedidoService.buscarPedidoPorId(id);
    }
}
