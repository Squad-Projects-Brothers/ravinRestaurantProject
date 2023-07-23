package main.repositories.InterfaceDAO;

import main.models.Pedido;

import java.util.List;

public interface PedidoDAO {
    void salvar(Pedido pedido);
    List<Pedido> listarTodos();
    void excluir(Pedido pedido);
    Pedido buscarPorId(int id);
}
