package main.services;

import main.enums.StatusComanda;
import main.enums.StatusMesa;
import main.models.Comanda;
import main.models.Mesa;
import main.models.Pedido;
import main.repositories.ComandaRepository;
import main.repositories.InterfaceDAO.ComandaDAO;
import main.repositories.MesaRepository;
import main.repositories.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

public class ComandaService {

    private ComandaDAO comandaDAO;
    private ComandaRepository comandaRepository;
    private MesaRepository mesaRepository;
    private PedidoRepository pedidoRepository;


    public ComandaService() {
        this.comandaDAO = new ComandaRepository();
        this.comandaRepository = new ComandaRepository();
        this.mesaRepository = new MesaRepository();
        this.pedidoRepository = new PedidoRepository();
    }

//----------------------------------------------------------------------------------------------------------------------
    public Comanda criarComandaEReservarMesa(int mesaId) {
        Mesa mesa = mesaRepository.buscarPorId(mesaId);
        if (mesa != null && mesa.getStatusMesa() == StatusMesa.LIVRE) {
            Comanda comanda = new Comanda();
            comanda.setMesa(mesa);
            comanda.setStatusComanda(StatusComanda.EM_ABERTO);
            comanda.setPedidos(new ArrayList<>()); // Inicializa a lista de pedidos vazia
            comanda.setValorTotal(0.0); // Inicializa o valor total como 0.0
            comandaRepository.salvar(comanda); // Salva a comanda no banco de dados
            mesa.setStatusMesa(StatusMesa.RESERVADA); // Atualiza o status da mesa para RESERVADA
            mesaRepository.salvar(mesa); // Atualiza a mesa no banco de dados

            return comanda;
        }

        return null; // Caso a mesa não exista ou não esteja disponível para reserva
    }

    // Método para adicionar um pedido e vinculá-lo à comanda
    public void adicionarPedidoAComanda(int comandaId, Pedido pedido) {
        Comanda comanda = comandaRepository.buscarPorId(comandaId);
        if (comanda != null) {
            pedido.setComanda(comanda); // Vincula o pedido à comanda
            pedidoRepository.salvar(pedido); // Salva o pedido no banco de dados
            comanda.getPedidos().add(pedido); // Adiciona o pedido à lista de pedidos da comanda
            comanda.setValorTotal(comanda.getValorTotal() + pedido.getProduto().getPrecoVenda() * pedido.getQuantidade()); // Atualiza o valor total da comanda
            comandaRepository.salvar(comanda); // Atualiza a comanda no banco de dados
        }
    }


    public void atualizarMesa(Mesa mesa) {
        mesaRepository.salvar(mesa);
    }

    // Método para atualizar os dados de uma comanda no banco de dados
    public void atualizarComanda(Comanda comanda) {
        comandaRepository.salvar(comanda);
    }

//----------------------------------------------------------------------------------------------------------------------

    public void salvarComanda(Comanda comanda) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        comandaDAO.salvar(comanda);
    }

    public List<Comanda> listarTodasComandas() {
        return comandaDAO.listarTodos();
    }

    public void excluirComanda(Comanda comanda) {
        comandaDAO.excluir(comanda);
    }

    public Comanda buscarComandaPorId(int id) {
        return comandaDAO.buscarPorId(id);
    }

}
