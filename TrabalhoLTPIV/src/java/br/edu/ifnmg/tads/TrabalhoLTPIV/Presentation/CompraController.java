/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Compra;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ICompraRepositorio;
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
@Named(value = "compraController")
@SessionScoped
public class CompraController implements Serializable {

    /**
     * Creates a new instance of CompraController
     */
    @EJB
    ICompraRepositorio dao;
    Compra entidade;
    Compra filtro;
    List<Compra> listagem;
    
    public CompraController() {
        this.entidade = new Compra();
        this.filtro = new Compra();
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
        return "CadastroCompra.xhtml";
    }
    
    public String criar(){
        entidade = new Compra();
        return "CadastroCompra.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemCompra.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemCompra.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemCompra.xhtml";
    }

    public ICompraRepositorio getDao() {
        return dao;
    }

    public void setDao(ICompraRepositorio dao) {
        this.dao = dao;
    }

    public Compra getEntidade() {
        return entidade;
    }

    public void setEntidade(Compra entidade) {
        this.entidade = entidade;
    }

    public Compra getFiltro() {
        return filtro;
    }

    public void setFiltro(Compra filtro) {
        this.filtro = filtro;
    }

    public List<Compra> getListagem() {
        return listagem;
    }

    public void setListagem(List<Compra> listagem) {
        this.listagem = listagem;
    }
    
}
