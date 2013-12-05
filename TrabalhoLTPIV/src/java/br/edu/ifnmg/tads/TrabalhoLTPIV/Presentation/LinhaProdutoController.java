/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ILinhasprodutoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Linhasproduto;
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
@Named(value = "linhaProdutoController")
@SessionScoped
public class LinhaProdutoController implements Serializable {

    /**
     * Creates a new instance of LinhaProdutoController
     */
    ILinhasprodutoRepositorio dao;
    Linhasproduto entidade;
    Linhasproduto filtro;
    List<Linhasproduto> listagem;
    
    public LinhaProdutoController() {
        this.entidade = new Linhasproduto();
        this.filtro = new Linhasproduto();        
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
        return "CadastroLinhaProduto.xhtml";
    }

    public String criar() {
        entidade = new Linhasproduto();
        return "CadastroLinhaProduto.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemLinhaProduto.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "index.xhtml";
    }

    public ILinhasprodutoRepositorio getDao() {
        return dao;
    }

    public void setDao(ILinhasprodutoRepositorio dao) {
        this.dao = dao;
    }

    public Linhasproduto getEntidade() {
        return entidade;
    }

    public void setEntidade(Linhasproduto entidade) {
        this.entidade = entidade;
    }

    public Linhasproduto getFiltro() {
        return filtro;
    }

    public void setFiltro(Linhasproduto filtro) {
        this.filtro = filtro;
    }

    public List<Linhasproduto> getListagem() {
        return listagem;
    }

    public void setListagem(List<Linhasproduto> listagem) {
        this.listagem = listagem;
    }
   
}
