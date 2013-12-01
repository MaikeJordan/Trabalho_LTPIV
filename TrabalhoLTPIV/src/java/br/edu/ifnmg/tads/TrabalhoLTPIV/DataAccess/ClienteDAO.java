/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Cliente;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IClienteRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IClientesRepositorio")
public class ClienteDAO extends DAOGenerico<Cliente> implements IClienteRepositorio{
   
    public ClienteDAO(){
        super(Cliente.class);
    }
    
    @Override
    public List<Cliente> Buscar(Cliente obj) {
        // Corpo da consulta
        String consulta = "select c from cliente c";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                filtro += " c.nome=:nome ";
                parametros.put("nome", obj.getNome());
            }
            
            //Cpf
            if (obj.getCpf() != null && obj.getCpf().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " c.cpf=:cpf ";
                parametros.put("cpf", obj.getCpf());
            }
          // Tipo
            
            if (obj.getTipo() != null && obj.getTipo().length() > 0) {
                filtro += " c.tipo=:tipo ";
                parametros.put("tipo", obj.getTipo());
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
    public boolean Apagar(Cliente obj) {
       try {
            Query query = manager.createQuery("Update cliente s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getId());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
