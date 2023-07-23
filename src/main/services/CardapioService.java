package main.services;

import main.models.Cardapio;
import main.repositories.InterfaceDAO.CardapioDAO;

import java.util.List;

public class CardapioService {

    private CardapioDAO cardapioDAO;

    public CardapioService(CardapioDAO cardapioDAO) {
        this.cardapioDAO = cardapioDAO;
    }

    public void salvarCardapio(Cardapio cardapio) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        cardapioDAO.salvar(cardapio);
    }

    public List<Cardapio> listarTodosCardapios() {
        return cardapioDAO.listarTodos();
    }

    public void excluirCardapio(Cardapio cardapio) {
        cardapioDAO.excluir(cardapio);
    }

    public Cardapio buscarCardapioPorId(int id) {
        return cardapioDAO.buscarPorId(id);
    }


}
