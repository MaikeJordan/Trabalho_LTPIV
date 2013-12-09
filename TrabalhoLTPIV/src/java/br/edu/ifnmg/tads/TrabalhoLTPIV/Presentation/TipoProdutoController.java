/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITipoprodutoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.TipoProduto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

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
    
    ITipoprodutoRepositorio dao;
    TipoProduto entidade;
    TipoProduto filtro;
    List<TipoProduto> listagem;

    
    public TipoProdutoController() {
        this.entidade = new TipoProduto();
        this.filtro = new TipoProduto();
    }

    
    public ITipoprodutoRepositorio getDao() {
        return dao;
    }

    public void setDao(ITipoprodutoRepositorio dao) {
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
