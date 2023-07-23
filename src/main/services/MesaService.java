package main.services;


import main.models.Mesa;
import main.repositories.InterfaceDAO.MesaDAO;
import main.repositories.MesaRepository;

import java.util.List;

public class MesaService {

    private MesaDAO mesaDAO;

    public MesaService() {
        this.mesaDAO = new MesaRepository();
    }


    public void salvarMesa(Mesa mesa) {
        // Aqui você pode adicionar validações, regras de negócio, cálculos, etc.
        mesaDAO.salvar(mesa);
    }

    public List<Mesa> listarTodosMesa() {
        return mesaDAO.listarTodos();
    }

    public void excluirMesa(Mesa mesa) {
        mesaDAO.excluir(mesa);
    }

    public Mesa buscarMesaPorId(int id) {
        return mesaDAO.buscarPorId(id);
    }

}
