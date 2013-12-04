/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IItemCompraRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ItemCompra;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IItemCompraRepositorio") 
public class ItemCompraDAO extends DAOGenerico<ItemCompra> implements IItemCompraRepositorio{
    
    public ItemCompraDAO(){
        super(ItemCompra.class);
    }
    
    @Override
    public List<ItemCompra> Buscar(ItemCompra obj) {
        // Corpo da consulta
        String consulta = "select c from itemcompra c";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Produto
            if (obj.getProdutoID().getNome()!= null && obj.getProdutoID().getNome().length() > 0) {
                
                filtro += " c.produtoID like '%"+obj.getProdutoID().getNome()+"%' ";
                //parametros.put("nome", obj.getProdutoID().getNome());
            }
            //Id
            if (obj.getItemCompraid() != null && obj.getItemCompraid() > 0) {
                
                 filtro += " c.ItemCompraid ="+obj.getItemCompraid();
                //parametros.put("id", obj.getItemCompraid());
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
    public boolean Apagar(ItemCompra obj) {
       try {
            Query query = manager.createQuery("Update itemcompra s set s.ativo = 0 WHERE s.ItemCompraid :=ItemCompraid");
            query.setParameter("ItemCompraid", obj.getItemCompraid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
