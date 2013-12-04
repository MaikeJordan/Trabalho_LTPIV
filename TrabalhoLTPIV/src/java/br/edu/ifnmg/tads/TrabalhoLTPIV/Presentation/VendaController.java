/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IVendaRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Venda;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Desktop
 */
@Named(value = "vendaController")
@SessionScoped
public class VendaController implements Serializable {

    /**
     * Creates a new instance of VendaController
     */
    @EJB
    IVendaRepositorio dao;
    Venda entidade;
    Venda filtro;
    List<Venda> listagem;
    
    public VendaController() {
        this.entidade = new Venda();
        this.filtro = new Venda();
    }
    
    public void exibirMensagem(String msg){
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Aviso",msg));
    }
    
    public void Salvar(){
        try{
            if(dao.verificaESalva(entidade)){
                listagem = null;
                exibirMensagem("Salvo Com Sucesso!");
                entidade = new Venda();
            } else {
                exibirMensagem("Erro ao Salvar");
            }
        } catch (Exception ex){
            exibirMensagem(ex.getMessage());
        }
    }
    
    public String Editar(){
        return "CadastroVenda.xhtml";
    }
    
    public String Criar(){
        entidade = new Venda();
        return "CadastroVenda.xhtml";
    }
    
    public String filtrar(){
        listagem = dao.Buscar(filtro);
        return "CadastroVenda.xhtml";
    }
    
    public String voltar(){
        listagem = null;
        return "ListagemVenda.xhtml";
    }
    
    public List<Venda> listarVenda(){
        listagem = dao.Buscar(filtro);
        return listagem;
    }
    
    public IVendaRepositorio getDao(){
        return dao;
    }
    
    public void setDao(IVendaRepositorio dao){
        this.dao = dao;
    }
    
    public Venda getEntidade(){
        return entidade;
    }
    
    public void setEntidade(Venda entidade){
        this.entidade = entidade;
    }

    public Venda getFiltro() {
        return filtro;
    }

    public void setFiltro(Venda filtro) {
        this.filtro = filtro;
    }

    public List<Venda> getListagem() {
        return listagem;
    }

    public void setListagem(List<Venda> listagem) {
        this.listagem = listagem;
    }
        
}
