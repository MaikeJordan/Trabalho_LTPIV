/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Estoques;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IEstoquesRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IEstoquesRepositorio")
public class EstoquesDAO extends DAOGenerico<Estoques> implements IEstoquesRepositorio{
    
    
    public EstoquesDAO(){
        super(Estoques.class);
    }
    
    @Override
    public List<Estoques> Buscar(Estoques obj) {
        // Corpo da consulta
        String consulta = "select e from estoques e";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getProdutos().getNome() != null && obj.getProdutos().getNome().length() > 0) {
                
                filtro += " e.produtos like '%"+obj.getProdutos().getNome()+"%' ";
                //parametros.put("nome", obj.getProdutos().getNome());
            }
            
            
          //Id
            if (obj.getEstoqueID() != null && obj.getEstoqueID() > 0) {
                
                filtro += " e.estoqueID ="+obj.getEstoqueID();
                //parametros.put("id", obj.getEstoqueID());
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
    public boolean Apagar(Estoques obj) {
       try {
            Query query = manager.createQuery("Update estoques s set s.ativo = 0 WHERE s.estoqueID :=estoqueID");
            query.setParameter("estoqueID", obj.getEstoqueID());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
