/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.FrotaAutomovel;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFrotasautomoveisRepositorio;
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
@Named(value = "frotaAutomovelController")
@SessionScoped
public class FrotaAutomovelController implements Serializable {

    /**
     * Creates a new instance of FrotaAutomovelController
     */
    @EJB
    IFrotasautomoveisRepositorio dao;
    FrotaAutomovel entidade;
    FrotaAutomovel filtro;
    List<FrotaAutomovel> listagem;
    public FrotaAutomovelController() {
        this.entidade = new FrotaAutomovel();
        this.filtro = new FrotaAutomovel();
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
        return "CadastroFrotaAutomovel.xhtml";
    }
    
    public String criar(){
        entidade = new FrotaAutomovel();
        return "CadastroFrotaAutomovel.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemFrotaAutomovel.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemFrotaAutomovel.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemFrotaAutomovel.xhtml";
    }

    public IFrotasautomoveisRepositorio getDao() {
        return dao;
    }

    public void setDao(IFrotasautomoveisRepositorio dao) {
        this.dao = dao;
    }

    public FrotaAutomovel getEntidade() {
        return entidade;
    }

    public void setEntidade(FrotaAutomovel entidade) {
        this.entidade = entidade;
    }

    public FrotaAutomovel getFiltro() {
        return filtro;
    }

    public void setFiltro(FrotaAutomovel filtro) {
        this.filtro = filtro;
    }

    public List<FrotaAutomovel> getListagem() {
        return listagem;
    }

    public void setListagem(List<FrotaAutomovel> listagem) {
        this.listagem = listagem;
    }

    
}
