/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Funcionario;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFuncionarioRepositorio;
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
@Named(value = "funcionarioController")
@SessionScoped
public class FuncionarioController implements Serializable {

    /**
     * Creates a new instance of FuncionarioController
     */
    @EJB
    IFuncionarioRepositorio dao;
    Funcionario entidade;
    Funcionario filtro;
    List<Funcionario> listagem;
    
    public FuncionarioController() {
        this.entidade = new Funcionario();
        this.filtro = new Funcionario();              
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
        return "CadastroFuncionario.xhtml";
    }
    
    public String criar(){
        entidade = new Funcionario();
        return "CadastroFuncionario.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemFuncionario.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemFuncionario.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemFuncionario.xhtml";
    }

    public IFuncionarioRepositorio getDao() {
        return dao;
    }

    public void setDao(IFuncionarioRepositorio dao) {
        this.dao = dao;
    }

    public Funcionario getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public Funcionario getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcionario filtro) {
        this.filtro = filtro;
    }

    public List<Funcionario> getListagem() {
        return listagem;
    }

    public void setListagem(List<Funcionario> listagem) {
        this.listagem = listagem;
    }

}
