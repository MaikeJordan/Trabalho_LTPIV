/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITipoProdutoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.TipoProduto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Maike
 */
@Named(value = "tipoProdutoController")
@SessionScoped
public class TipoProdutoController implements Serializable {

    /**
     * Creates a new instance of TipoProdutoController
     */
    
    ITipoProdutoRepositorio dao;
    TipoProduto entidade;
    TipoProduto filtro;
    List<TipoProduto> listagem;

    
    public TipoProdutoController() {
        this.entidade = new TipoProduto();
        this.filtro = new TipoProduto();
    }

    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aviso",msg));
    }
    
    public void salvar(){
        dao.Salvar(entidade);
        listagem = null;
        exibirMensagem("Salvo com sucesso!");
    }
    
    public String editar(){
        return "CadastroTipoProduto.xhtml";
    }
    
    public String criar(){
        entidade = new TipoProduto();
        return "CadastroTipoProduto.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemTipoProduto.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemTipoProduto.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemTipoProduto.xhtml";
    }
    
    public ITipoProdutoRepositorio getDao() {
        return dao;
    }

    public void setDao(ITipoProdutoRepositorio dao) {
        this.dao = dao;
    }

    public TipoProduto getEntidade() {
        return entidade;
    }

    public void setEntidade(TipoProduto entidade) {
        this.entidade = entidade;
    }

    public TipoProduto getFiltro() {
        return filtro;
    }

    public void setFiltro(TipoProduto filtro) {
        this.filtro = filtro;
    }

    public List<TipoProduto> getListagem() {
        return listagem;
    }

    public void setListagem(List<TipoProduto> listagem) {
        this.listagem = listagem;
    }
    
}
