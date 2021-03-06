/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITabelasprecoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Tabelaspreco;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "ITabelasprecoRepositorio")
public class TabelasprecoDAO extends DAOGenerico<Tabelaspreco> implements ITabelasprecoRepositorio{
    
    public TabelasprecoDAO(){
        super(Tabelaspreco.class);
    }
    
    @Override
    public List<Tabelaspreco> Buscar(Tabelaspreco obj) {
        // Corpo da consulta
        String consulta = "select t from tabelaspreco t";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Data cadastro
            if (obj.getDatacadastro() != null && obj.getDatacadastro().before(null)) {
                
                filtro += " t.datacadastro ="+obj.getDatacadastro();
                //parametros.put("datacadastro", obj.getDatacadastro());
            }
            
            //Data modificação
            if (obj.getDatamodificacao() != null && obj.getDatamodificacao().before(null)) {
                
                filtro += " t.datamodificacao ="+obj.getDatamodificacao();
               //parametros.put("datamodificacao", obj.getDatamodificacao());
            }
            
            //Produto
            if (obj.getProduto().getNome()!= null && obj.getProduto().getNome().length() > 0) {
                
                filtro += " t.produto like '%"+obj.getProduto().getNome()+"%' ";
                //parametros.put("nome", obj.getProduto().getNome());
            }
            //Id
            if (obj.getId() != null && obj.getId() > 0) {
                
                filtro += " t.id ="+obj.getId();
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
    public boolean Apagar(Tabelaspreco obj) {
       try {
            Query query = manager.createQuery("Update tabelapreco s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getId());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
