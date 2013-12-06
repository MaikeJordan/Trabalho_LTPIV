/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Estoques;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IEstoquesRepositorio;
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
@Named(value = "estoqueController")
@SessionScoped
public class EstoqueController implements Serializable {

    /**
     * Creates a new instance of EstoqueController
     */
    @EJB
    IEstoquesRepositorio dao;
    Estoques entidade;
    Estoques filtro;
    List<Estoques> listagem;
    
    public EstoqueController() {
        this.entidade = new Estoques();
        this.filtro = new Estoques();
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
        return "CadastroEstoques.xhtml";
    }
    
    public String criar(){
        entidade = new Estoques();
        return "CadastroEstoques.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemEstoques.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemEstoques.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemEstoques.xhtml";
    }

    public IEstoquesRepositorio getDao() {
        return dao;
    }

    public void setDao(IEstoquesRepositorio dao) {
        this.dao = dao;
    }

    public Estoques getEntidade() {
        return entidade;
    }

    public void setEntidade(Estoques entidade) {
        this.entidade = entidade;
    }

    public Estoques getFiltro() {
        return filtro;
    }

    public void setFiltro(Estoques filtro) {
        this.filtro = filtro;
    }

    public List<Estoques> getListagem() {
        return listagem;
    }

    public void setListagem(List<Estoques> listagem) {
        this.listagem = listagem;
    }

}
