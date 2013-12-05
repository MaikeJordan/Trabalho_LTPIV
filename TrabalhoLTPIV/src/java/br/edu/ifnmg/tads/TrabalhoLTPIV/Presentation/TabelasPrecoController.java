/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITabelasprecoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Tabelaspreco;
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
@Named(value = "telefoneController")
@SessionScoped
public class TabelasPrecoController implements Serializable {

    /**
     * Creates a new instance of TelefoneController
     */
    ITabelasprecoRepositorio dao;
    Tabelaspreco entidade;
    Tabelaspreco filtro;
    List<Tabelaspreco> listagem;
    
    public TabelasPrecoController() {
        this.entidade = new Tabelaspreco();
        this.filtro = new Tabelaspreco(); 
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
        return "CadastroTabelasPreco.xhtml";
    }

    public String criar() {
        entidade = new Tabelaspreco();
        return "CadastroTabelasPreco.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemTabelasPreco.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "index.xhtml";
    }

    public ITabelasprecoRepositorio getDao() {
        return dao;
    }

    public void setDao(ITabelasprecoRepositorio dao) {
        this.dao = dao;
    }

    public Tabelaspreco getEntidade() {
        return entidade;
    }

    public void setEntidade(Tabelaspreco entidade) {
        this.entidade = entidade;
    }

    public Tabelaspreco getFiltro() {
        return filtro;
    }

    public void setFiltro(Tabelaspreco filtro) {
        this.filtro = filtro;
    }

    public List<Tabelaspreco> getListagem() {
        return listagem;
    }

    public void setListagem(List<Tabelaspreco> listagem) {
        this.listagem = listagem;
    }
    
}
