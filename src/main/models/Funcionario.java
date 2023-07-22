package main.models;

import main.enums.Cargo;
import main.enums.Escolaridade;
import main.enums.EstadoCivil;

import java.util.Date;

public class Funcionario extends Pessoa{

    private int id;
    private String rg;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private Cargo cargo;
    private String numeroCarteiraTrabalho;
    private Date dataAdmissao;
    private Date dataDemissao;
    private boolean disponivel;

    public Funcionario(){}

    public Funcionario(int id, String rg, EstadoCivil estadoCivil, Escolaridade escolaridade, Cargo cargo, String numeroCarteiraTrabalho, Date dataAdmissao, Date dataDemissao, boolean disponivel) {
        this.id = id;
        this.rg = rg;
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
        this.cargo = cargo;
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.disponivel = disponivel;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNumeroCarteiraTrabalho() {
        return numeroCarteiraTrabalho;
    }

    public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
        this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
