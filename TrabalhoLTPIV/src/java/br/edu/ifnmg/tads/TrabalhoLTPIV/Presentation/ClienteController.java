/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Cliente;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IClienteRepositorio;
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
@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable {

    /**
     * Creates a new instance of ClienteController
     */
    @EJB
    IClienteRepositorio dao;
    Cliente entidade;
    Cliente filtro;
    List<Cliente> listagem;
    
    public ClienteController() {
        this.entidade = new Cliente();
        this.filtro = new Cliente();        
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
        return "CadastroCliente.xhtml";
    }
    
    public String criar(){
        entidade = new Cliente();
        return "CadastroCliente.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemCliente.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemCliente.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemCliente.xhtml";
    }

    public IClienteRepositorio getDao() {
        return dao;
    }

    public void setDao(IClienteRepositorio dao) {
        this.dao = dao;
    }

    public Cliente getEntidade() {
        return entidade;
    }

    public void setEntidade(Cliente entidade) {
        this.entidade = entidade;
    }

    public Cliente getFiltro() {
        return filtro;
    }

    public void setFiltro(Cliente filtro) {
        this.filtro = filtro;
    }

    public List<Cliente> getListagem() {
        return listagem;
    }

    public void setListagem(List<Cliente> listagem) {
        this.listagem = listagem;
    }

    
}
