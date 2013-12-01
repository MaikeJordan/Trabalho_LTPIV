/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Fornecedor;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFornecedorRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IFornecedorRepositorio")
public class FornecedorDAO extends DAOGenerico<Fornecedor> implements IFornecedorRepositorio{
    
    public FornecedorDAO(){
        super(Fornecedor.class);
    }
    
      @Override
    public List<Fornecedor> Buscar(Fornecedor obj) {
        // Corpo da consulta
        String consulta = "select f from fornecedor f";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " f.nome=:nome ";
                parametros.put("nome", obj.getNome());
            }
            
            //Cnpj
            if (obj.getCnpj() != null && obj.getCnpj().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.cnpj=:cnpj ";
                parametros.put("cnpj", obj.getCnpj());
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
    public boolean Apagar(Fornecedor obj) {
       try {
            Query query = manager.createQuery("Update fornecedor f set f.ativo = 0 WHERE f.id :=id");
            query.setParameter("id", obj.getId());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
