package main.controller;

import main.models.Comanda;
import main.services.ComandaService;

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
}
