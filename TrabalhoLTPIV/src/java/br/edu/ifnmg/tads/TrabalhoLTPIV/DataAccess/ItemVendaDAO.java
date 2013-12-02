/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IItemVendaRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ItemVenda;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IItemVendaRepositorio")
public class ItemVendaDAO extends DAOGenerico<ItemVenda> implements IItemVendaRepositorio{
    
    public ItemVendaDAO(){
        super(ItemVenda.class);
    }
    
    @Override
    public List<ItemVenda> Buscar(ItemVenda obj) {
        // Corpo da consulta
        String consulta = "select v from itemvenda v";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Produto
            if (obj.getProdutoID().getNome()!= null && obj.getProdutoID().getNome().length() > 0) {
                filtro += " v.nome=:nome ";
                parametros.put("nome", obj.getProdutoID().getNome());
            }
            //Id
            if (obj.getItemVendaid() != null && obj.getItemVendaid() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " v.id =:id";
                parametros.put("id", obj.getItemVendaid());
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
    public boolean Apagar(ItemVenda obj) {
       try {
            Query query = manager.createQuery("Update itemvenda s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getItemVendaid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
