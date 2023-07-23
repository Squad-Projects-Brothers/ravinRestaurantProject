package main.controller;

import main.models.Cardapio;
import main.services.CardapioService;

import java.util.List;

public class CardapioController {
    private CardapioService cardapioService;

    public CardapioController() {
        cardapioService = new CardapioService();
    }

    public void salvarCardapio(Cardapio cardapio) {
        cardapioService.salvarCardapio(cardapio);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Cardapio> listarTodosCardapios() {
        return cardapioService.listarTodosCardapios();
    }

    public void excluirCardapio(Cardapio cardapio) {
        cardapioService.excluirCardapio(cardapio);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Cardapio buscarCardapioPorId(int id) {
        return cardapioService.buscarCardapioPorId(id);
    }
}
