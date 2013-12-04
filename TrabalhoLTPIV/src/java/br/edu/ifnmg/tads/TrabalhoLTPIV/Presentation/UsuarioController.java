/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IUsuarioRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Maike
 */
@Named(value = "usuarioController")
@Dependent
public class UsuarioController {

    /**
     * Creates a new instance of UsuarioController
     */
    @EJB
    IUsuarioRepositorio dao;
    Usuario entidade;
    Usuario filtro;
    List<Usuario> listagem;

    public UsuarioController() {
        this.entidade = new Usuario();
        this.filtro = new Usuario();
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
        return "CadastroUsuario.xhtml";
    }
    
    public String criar(){
        entidade = new Usuario();
        return "CadastroUsuario.xhtml";
    }
    
    public String apagar(){
        dao.Apagar(entidade);
        listagem = null;
        exibirMensagem("Apagado com sucesso!");
        return "ListagemUsuario.xhtml";
    }
    
    public String filtrar() {
        listagem = dao.Buscar(filtro);
        return "ListagemUsuario.xhtml";
    }

    public String voltar(){
        listagem = null;
        return "ListagemUsuario.xhtml";
    }

    public IUsuarioRepositorio getDao() {
        return dao;
    }

    public void setDao(IUsuarioRepositorio dao) {
        this.dao = dao;
    }

    public Usuario getEntidade() {
        return entidade;
    }

    public void setEntidade(Usuario entidade) {
        this.entidade = entidade;
    }

    public Usuario getFiltro() {
        return filtro;
    }

    public void setFiltro(Usuario filtro) {
        this.filtro = filtro;
    }

    public List<Usuario> getListagem() {
        return listagem;
    }

    public void setListagem(List<Usuario> listagem) {
        this.listagem = listagem;
    }
    
}
