/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IRotasRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Rotas;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IRotasRepositorio")
public class RotasDAO extends DAOGenerico<Rotas> implements IRotasRepositorio{
    
    public RotasDAO(){
        super(Rotas.class);
    }
    
    @Override
    public List<Rotas> Buscar(Rotas obj) {
        // Corpo da consulta
        String consulta = "select r from rotas r";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            
            //Nome cidade origem
            if (obj.getCidadeorigem().getNome() != null && obj.getCidadeorigem().getNome().length() > 0) {
                
                filtro += " r.cidadeorigem like '%"+obj.getCidadeorigem()+"%' ";
               // parametros.put("nome", obj.getCidadeorigem().getNome());
            }
            //Nome cidade destino
            if (obj.getCidadedestino().getNome() != null && obj.getCidadedestino().getNome().length() > 0) {
                
                filtro += " r.cidadedestino like '%"+obj.getCidadedestino()+"%' ";
                //parametros.put("nome", obj.getCidadedestino().getNome());
            }
            
            //Distância
            if (obj.getDistancia() != 0 && obj.getDistancia() > 0) {
                
                filtro += " r.distancia ="+obj.getDistancia();
                //parametros.put("distancia", obj.getDistancia());
            }
   
            //Id
            if (obj.getId() != null && obj.getId() > 0) {
                
                filtro += " r.id ="+obj.getId();
                //parametros.put("id", obj.getId());
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
    public boolean Apagar(Rotas obj) {
       try {
            Query query = manager.createQuery("Update rotas s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getId());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
