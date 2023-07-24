package main.controllers;

import main.enums.StatusComanda;
import main.enums.StatusMesa;
import main.models.Comanda;
import main.models.Mesa;
import main.models.Pedido;
import main.services.ComandaService;
import main.services.MesaService;

import java.util.List;

public class ComandaController {
    private ComandaService comandaService;

    public ComandaController() {
        comandaService = new ComandaService();
    }

    public void salvarComanda(Comanda comanda) {
        comandaService.salvarComanda(comanda);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Comanda> listarTodasComandas() {
        return comandaService.listarTodasComandas();
    }

    public void excluirComanda(Comanda comanda) {
        comandaService.excluirComanda(comanda);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Comanda buscarComandaPorId(int id) {
        return comandaService.buscarComandaPorId(id);
    }

//----------------------------------------------------------------------------------------------------------------------

    public Comanda criarComandaEReservarMesa(int mesaId) {
        return comandaService.criarComandaEReservarMesa(mesaId);
    }

    // Método para adicionar um pedido e vinculá-lo à comanda
    public void adicionarPedidoAComanda(int comandaId, Pedido pedido) {
        comandaService.adicionarPedidoAComanda(comandaId, pedido);
    }

    // Método para fechar uma comanda e liberar a mesa
    public void fecharComandaELiberarMesa(int comandaId) {
        Comanda comanda = comandaService.buscarComandaPorId(comandaId);
        if (comanda != null && comanda.getStatusComanda() == StatusComanda.EM_ABERTO) {
            // Calcula o valor total da comanda e atualiza o status para FECHADA
            double valorTotal = calcularValorTotalComanda(comanda);
            comanda.setValorTotal(valorTotal);
            comanda.setStatusComanda(StatusComanda.FECHADA);

            // Atualiza a comanda no banco de dados
            comandaService.atualizarComanda(comanda);

            // Libera a mesa associada à comanda
            liberarMesa(comanda.getMesa());
        }
    }

    // Método para calcular o valor total da comanda
    private double calcularValorTotalComanda(Comanda comanda) {
        double valorTotal = 0.0;
        for (Pedido pedido : comanda.getPedidos()) {
            valorTotal += pedido.getProduto().getPrecoVenda() * pedido.getQuantidade();
        }
        return valorTotal;
    }

    // Método para liberar uma mesa
    private void liberarMesa(Mesa mesa) {
        mesa.setStatusMesa(StatusMesa.LIVRE);
        comandaService.atualizarMesa(mesa);
    }


}
