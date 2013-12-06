/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IItemCompraRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ItemCompra;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author HERICK
 */
@Named(value = "itemCompraController")
@SessionScoped
public class ItemCompraController implements Serializable {

    /**
     * Creates a new instance of ItemCompraController
     */
    
    @EJB
    IItemCompraRepositorio dao;
    ItemCompra entidade;
    ItemCompra filtro;
    List<ItemCompra> listagem;
    
    public ItemCompraController() {
        this.entidade = new ItemCompra();
        this.filtro = new ItemCompra();
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
        return "CadastroItemCompra.xhtml";
    }
    
    public String criar(){
        entidade = new ItemCompra();
        return "CadastroItemCompra.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemItemCompra.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemItemCompra.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemItemCompra.xhtml";
    }

    public IItemCompraRepositorio getDao() {
        return dao;
    }

    public void setDao(IItemCompraRepositorio dao) {
        this.dao = dao;
    }

    public ItemCompra getEntidade() {
        return entidade;
    }

    public void setEntidade(ItemCompra entidade) {
        this.entidade = entidade;
    }

    public ItemCompra getFiltro() {
        return filtro;
    }

    public void setFiltro(ItemCompra filtro) {
        this.filtro = filtro;
    }

    public List<ItemCompra> getListagem() {
        return listagem;
    }

    public void setListagem(List<ItemCompra> listagem) {
        this.listagem = listagem;
    }

}
