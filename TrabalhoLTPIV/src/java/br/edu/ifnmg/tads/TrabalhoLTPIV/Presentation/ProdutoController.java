/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IProdutosRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Produtos;
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
@Named(value = "produtoController")
@SessionScoped
public class ProdutoController implements Serializable {

    /**
     * Creates a new instance of ProdutoController
     */
    IProdutosRepositorio dao;
    Produtos entidade;
    Produtos filtro;
    List<Produtos> listagem;
    
    public ProdutoController(){
        this.entidade = new Produtos();
        this.filtro = new Produtos();
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
        return "CadastroProdutos.xhtml";
    }

    public String criar() {
        entidade = new Produtos();
        return "CadastroProdutos.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemProdutos.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "index.xhtml";
    }

    public IProdutosRepositorio getDao() {
        return dao;
    }

    public void setDao(IProdutosRepositorio dao) {
        this.dao = dao;
    }

    public Produtos getEntidade() {
        return entidade;
    }

    public void setEntidade(Produtos entidade) {
        this.entidade = entidade;
    }

    public Produtos getFiltro() {
        return filtro;
    }

    public void setFiltro(Produtos filtro) {
        this.filtro = filtro;
    }

    public List<Produtos> getListagem() {
        return listagem;
    }

    public void setListagem(List<Produtos> listagem) {
        this.listagem = listagem;
    }

}
