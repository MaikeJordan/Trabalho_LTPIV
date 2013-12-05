/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITipoFuncionarioRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.TipoFuncionario;
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
@Named(value = "tipoFuncionarioController")
@SessionScoped
public class TipoFuncionarioController implements Serializable {

    /**
     * Creates a new instance of TipoFuncionarioController
     */
    ITipoFuncionarioRepositorio dao;
    TipoFuncionario entidade;
    TipoFuncionario filtro;
    List<TipoFuncionario> listagem;
    
    public TipoFuncionarioController() {
        this.entidade = new TipoFuncionario();
        this.filtro = new TipoFuncionario();
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
        return "CadastroTipoFuncionario.xhtml";
    }

    public String criar() {
        entidade = new TipoFuncionario();
        return "CadastroTipoFuncionario.xhtml";
    }

    public String apagar() {
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemTipoFuncionario.xhtml";
    }

    public String voltar() {
        listagem = null;
        return "index.xhtml";
    }
    
    public List<TipoFuncionario> listarNacionalidade(){
        listagem = dao.Buscar(filtro);
        return listagem;
    }

    public ITipoFuncionarioRepositorio getDao() {
        return dao;
    }

    public void setDao(ITipoFuncionarioRepositorio dao) {
        this.dao = dao;
    }

    public TipoFuncionario getEntidade() {
        return entidade;
    }

    public void setEntidade(TipoFuncionario entidade) {
        this.entidade = entidade;
    }

    public TipoFuncionario getFiltro() {
        return filtro;
    }

    public void setFiltro(TipoFuncionario filtro) {
        this.filtro = filtro;
    }

    public List<TipoFuncionario> getListagem() {
        return listagem;
    }

    public void setListagem(List<TipoFuncionario> listagem) {
        this.listagem = listagem;
    }
    
    
}
