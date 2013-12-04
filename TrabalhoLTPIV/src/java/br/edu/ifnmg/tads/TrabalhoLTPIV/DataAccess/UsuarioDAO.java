/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IUsuarioRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Usuario;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IUsuarioRepositorio")
public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioRepositorio{
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    @Override
    public List<Usuario> Buscar(Usuario obj) {
        // Corpo da consulta
        String consulta = "select u from Usuario u";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getLogin()!= null && obj.getLogin().length() > 0) {
                
                 filtro += " u.login like '%"+obj.getLogin()+"%' ";
                //parametros.put("login", obj.getLogin());
            }
            //Id
            if (obj.getUsuarioid()!= null && obj.getUsuarioid() > 0) {
                
                filtro += " u.id ="+obj.getUsuarioid();
                //parametros.put("id", obj.getFuncionario().getPessoaid());
            }

            // Se houver filtros, coloca o "where" na consulta
            if (filtro.length() > 0) {
                consulta = consulta + " where " + filtro;
            }
        }

        // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        for (String par : parametros.keySet()) {
            query.setParameter(par, parametros.get(par));
        }

        // Executa a consulta
        return query.getResultList();

    }
    
    @Override
     public Usuario porLogin(String login){
        String consulta = "select f from usuario f where f.ativo = 1 and f.login=:login ";
                // Cria a consulta no JPA
        Query query = manager.createQuery(consulta);

        // Aplica os parâmetros da consulta
        query.setParameter("login", login);
        
        try{
        // Executa a consulta
            return (Usuario)query.getSingleResult();
        }catch(NoResultException ex){
            ex.printStackTrace();
            return null;
        }
        


    }

    @Override
    public boolean Apagar(Usuario obj) {
       try {
            Query query = manager.createQuery("Update usuario s set s.ativo = 0 WHERE s.Usuarioid :=Usuarioid");
            query.setParameter("Usuarioid", obj.getUsuarioid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
