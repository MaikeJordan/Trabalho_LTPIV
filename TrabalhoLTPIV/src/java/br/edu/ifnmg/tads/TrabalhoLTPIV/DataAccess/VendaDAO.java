/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IVendaRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Venda;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IVendaRepositorio")
public class VendaDAO extends DAOGenerico<Venda> implements IVendaRepositorio {

    public VendaDAO() {
        super(Venda.class);
    }

    @Override
    public List<Venda> Buscar(Venda obj) {
        // Corpo da consulta
        String consulta = "select v from venda v";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Data
            if (obj.getData() != null && obj.getData().before(null)) {
                filtro += " c.data=:data ";
                parametros.put("data", obj.getData());
            }
            //Id
            if (obj.getVendaid() != null && obj.getVendaid() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " c.id =:id";
                parametros.put("id", obj.getVendaid());
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
    public boolean Apagar(Venda obj) {
        try {
            Query query = manager.createQuery("Update venda s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getVendaid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

}
