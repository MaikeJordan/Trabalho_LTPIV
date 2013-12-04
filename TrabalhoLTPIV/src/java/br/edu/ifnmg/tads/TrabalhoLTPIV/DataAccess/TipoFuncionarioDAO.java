/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITipoFuncionarioRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.TipoFuncionario;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "ITipoFuncionarioRepositorio")
public class TipoFuncionarioDAO extends DAOGenerico<TipoFuncionario> implements ITipoFuncionarioRepositorio{
    
    public TipoFuncionarioDAO(){
        super(TipoFuncionario.class);
    }
    
    @Override
    public List<TipoFuncionario> Buscar(TipoFuncionario obj) {
         // Corpo da consulta
        String consulta = "select f from tipofuncionario f";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                
                filtro += " f.nome like '%"+obj.getNome()+"%' ";
                //parametros.put("nome", obj.getNome());
            }
            //Id
            if (obj.getTipoFuncionarioid() != null && obj.getTipoFuncionarioid() > 0) {
                
                filtro += " f.TipoFuncionarioid ="+obj.getTipoFuncionarioid();
                //parametros.put("id", obj.getTipoFuncionarioid());
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
    public boolean Apagar(TipoFuncionario obj) {
        try {
            Query query = manager.createQuery("Update tipofuncionario s set s.ativo = 0 WHERE s.TipoFuncionarioid :=TipoFuncionarioid");
            query.setParameter("TipoFuncionarioid", obj.getTipoFuncionarioid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
