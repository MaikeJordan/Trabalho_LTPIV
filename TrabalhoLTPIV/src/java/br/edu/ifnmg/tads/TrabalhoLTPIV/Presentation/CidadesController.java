/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Cidades;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ICidadesRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Mauro
 */
@Named(value = "CidadesController")
@SessionScoped
public class CidadesController implements Serializable{

    /**
     * Creates a new instance of CidadesController
     */
    
    @EJB
    ICidadesRepositorio dao;
    Cidades entidade;
    Cidades filtro;
    Cidades f;
    List<Cidades> listagem;
    
    
    
    public CidadesController() {
        entidade = new Cidades();
        filtro = new Cidades();
        f = new Cidades();
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
        return "ListagemCidades.xhtml";
    }
    
    public String criar(){
        entidade = new Cidades();
        return "CadastroCidades.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemCidades.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "TipoFuncionarioListagem";
    }

    
    public String voltar(){
        return "index.xhtml";
    }
    
    
    
    public List<Cidades> filtrarCidade(){
       
        listagem = dao.Buscar(f);
        return listagem;
        
    }

    public ICidadesRepositorio getDao() {
        return dao;
    }

    public void setDao(ICidadesRepositorio dao) {
        this.dao = dao;
    }

    public Cidades getEntidade() {
        return entidade;
    }

    public void setEntidade(Cidades entidade) {
        this.entidade = entidade;
    }

    public Cidades getFiltro() {
        return filtro;
    }

    public void setFiltro(Cidades filtro) {
        this.filtro = filtro;
    }

    public List<Cidades> getListagem() {
        return listagem;
    }

    public void setListagem(List<Cidades> listagem) {
        this.listagem = listagem;
    }

    
    
}
