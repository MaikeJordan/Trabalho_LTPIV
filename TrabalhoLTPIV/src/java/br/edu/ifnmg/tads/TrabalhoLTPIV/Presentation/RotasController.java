/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IRotasRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Rotas;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author HERICK
 */
@Named(value = "rotasController")
@SessionScoped
public class RotasController implements Serializable {

    /**
     * Creates a new instance of RotasController
     */
    IRotasRepositorio dao;
    Rotas entidade;
    Rotas filtro;
    List<Rotas> listagem;

    public RotasController() {
        this.entidade = new Rotas();
        this.filtro = new Rotas();
    }

    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aviso",msg));
    }

    public void salvar() {
        dao.Salvar(entidade);
        listagem = null;
        exibirMensagem("Salvo com Sucesso!");

    }

    public String editar() {
        return "CadastroRotas.xhtml";
    }

    public String criar() {
        entidade = new Rotas();
        return "CadastroRotas.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemRotas.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "index.xhtml";
    }

    public IRotasRepositorio getDao() {
        return dao;
    }

    public void setDao(IRotasRepositorio dao) {
        this.dao = dao;
    }

    public Rotas getEntidade() {
        return entidade;
    }

    public void setEntidade(Rotas entidade) {
        this.entidade = entidade;
    }

    public Rotas getFiltro() {
        return filtro;
    }

    public void setFiltro(Rotas filtro) {
        this.filtro = filtro;
    }

    public List<Rotas> getListagem() {
        return listagem;
    }

    public void setListagem(List<Rotas> listagem) {
        this.listagem = listagem;
    }

}
