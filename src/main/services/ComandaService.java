package main.services;

import main.models.Comanda;
import main.repositories.ComandaRepository;
import main.repositories.InterfaceDAO.ComandaDAO;

import java.util.List;

public class ComandaService {

    private ComandaDAO comandaDAO;

    public ComandaService() {
        this.comandaDAO = new ComandaRepository();
    }

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
