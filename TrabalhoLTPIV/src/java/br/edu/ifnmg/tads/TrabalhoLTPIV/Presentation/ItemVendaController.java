/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IItemVendaRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ItemVenda;
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
@Named(value = "itemVendaController")
@SessionScoped
public class ItemVendaController implements Serializable {

    /**
     * Creates a new instance of ItemVendaController
     */
    @EJB
    IItemVendaRepositorio dao;
    ItemVenda entidade;
    ItemVenda filtro;
    List<ItemVenda> listagem;
    
    public ItemVendaController() {
        this.entidade = new ItemVenda();
        this.filtro = new ItemVenda();
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
        return "CadastroItemVenda.xhtml";
    }
    
    public String criar(){
        entidade = new ItemVenda();
        return "CadastroItemVenda.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemItemVenda.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemItemVenda.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemItemVenda.xhtml";
    }

    public IItemVendaRepositorio getDao() {
        return dao;
    }

    public void setDao(IItemVendaRepositorio dao) {
        this.dao = dao;
    }

    public ItemVenda getEntidade() {
        return entidade;
    }

    public void setEntidade(ItemVenda entidade) {
        this.entidade = entidade;
    }

    public ItemVenda getFiltro() {
        return filtro;
    }

    public void setFiltro(ItemVenda filtro) {
        this.filtro = filtro;
    }

    public List<ItemVenda> getListagem() {
        return listagem;
    }

    public void setListagem(List<ItemVenda> listagem) {
        this.listagem = listagem;
    }

    
}
