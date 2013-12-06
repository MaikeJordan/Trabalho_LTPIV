/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Entrega;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IEntregaRepositorio;
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
@Named(value = "entregaController")
@SessionScoped
public class EntregaController implements Serializable {

    /**
     * Creates a new instance of EntregaController
     */
    @EJB
    IEntregaRepositorio dao;
    Entrega entidade;
    Entrega filtro;
    List<Entrega> listagem;
    
    public EntregaController() {
        this.entidade = new Entrega();
        this.filtro =   new Entrega();
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
        return "CadastroEntrega.xhtml";
    }
    
    public String criar(){
        entidade = new Entrega();
        return "CadastroEntrega.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemEntrega.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemEntrega.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemEntrega.xhtml";
    }

    public IEntregaRepositorio getDao() {
        return dao;
    }

    public void setDao(IEntregaRepositorio dao) {
        this.dao = dao;
    }

    public Entrega getEntidade() {
        return entidade;
    }

    public void setEntidade(Entrega entidade) {
        this.entidade = entidade;
    }

    public Entrega getFiltro() {
        return filtro;
    }

    public void setFiltro(Entrega filtro) {
        this.filtro = filtro;
    }

    public List<Entrega> getListagem() {
        return listagem;
    }

    public void setListagem(List<Entrega> listagem) {
        this.listagem = listagem;
    }

    
}
