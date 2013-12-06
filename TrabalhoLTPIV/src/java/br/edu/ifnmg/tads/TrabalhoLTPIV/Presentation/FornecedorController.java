/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Fornecedor;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFornecedorRepositorio;
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
@Named(value = "fornecedorController")
@SessionScoped
public class FornecedorController implements Serializable {

    /**
     * Creates a new instance of FornecedorController
     */
    @EJB
    IFornecedorRepositorio dao;
    Fornecedor entidade;
    Fornecedor filtro;
    List<Fornecedor> listagem;
    
    public FornecedorController() {
        this.entidade = new Fornecedor();
        this.filtro = new Fornecedor();
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
        return "CadastroFornecedor.xhtml";
    }
    
    public String criar(){
        entidade = new Fornecedor();
        return "CadastroFornecedor.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemFornecedor.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemFornecedor.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemFornecedor.xhtml";
    }

    public IFornecedorRepositorio getDao() {
        return dao;
    }

    public void setDao(IFornecedorRepositorio dao) {
        this.dao = dao;
    }

    public Fornecedor getEntidade() {
        return entidade;
    }

    public void setEntidade(Fornecedor entidade) {
        this.entidade = entidade;
    }

    public Fornecedor getFiltro() {
        return filtro;
    }

    public void setFiltro(Fornecedor filtro) {
        this.filtro = filtro;
    }

    public List<Fornecedor> getListagem() {
        return listagem;
    }

    public void setListagem(List<Fornecedor> listagem) {
        this.listagem = listagem;
    }
    
    
}
