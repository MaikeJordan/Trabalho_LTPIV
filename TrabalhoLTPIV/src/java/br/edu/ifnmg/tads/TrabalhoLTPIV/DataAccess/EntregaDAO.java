/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Entrega;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IEntregaRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IEntregaRepositorio")
public class EntregaDAO extends DAOGenerico<Entrega> implements IEntregaRepositorio{
    
    public EntregaDAO(){
        super(Entrega.class);
    }
    
    @Override
    public List<Entrega> Buscar(Entrega obj) {
        // Corpo da consulta
        String consulta = "select e from entrega e";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Data
            if (obj.getData() != null && obj.getData().before(null)) {
                filtro += " e.data=:data ";
                parametros.put("data", obj.getData());
            }
            //Id
            if (obj.getEntregaid() != null && obj.getEntregaid() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " e.id =:id";
                parametros.put("id", obj.getEntregaid());
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
    public boolean Apagar(Entrega obj) {
       try {
            Query query = manager.createQuery("Update entrega s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getEntregaid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
