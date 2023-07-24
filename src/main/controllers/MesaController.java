package main.controllers;

import main.models.Mesa;
import main.services.MesaService;

import java.util.List;

public class MesaController {
    private MesaService mesaService;

    public MesaController() {
        mesaService = new MesaService();
    }

    public void salvarMesa(Mesa mesa) {
        mesaService.salvarMesa(mesa);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public List<Mesa> listarTodasMesas() {
        return mesaService.listarTodosMesa();
    }

    public void excluirMesa(Mesa mesa) {
        mesaService.excluirMesa(mesa);
        // Retornar a resposta apropriada ao front-end, se necessário
    }

    public Mesa buscarMesaPorId(int id) {
        return mesaService.buscarMesaPorId(id);
    }
}

