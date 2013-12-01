/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Funcionario;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFuncionarioRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IFuncionarioRepositorio")
public class FuncionarioDAO extends DAOGenerico<Funcionario> implements IFuncionarioRepositorio{
    
    public FuncionarioDAO(){
        super(Funcionario.class);
    }
    
    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
         // Corpo da consulta
        String consulta = "select f from funcionario f";

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
            //Id
            if (obj.getPessoaid() != null && obj.getPessoaid() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.id=:id ";
                parametros.put("id", obj.getPessoaid());
            }
            //Cpf
            if (obj.getCpf() != null && obj.getCpf().length() > 0) {
                if (filtro.length() > 0) {
                    filtro = filtro + " and ";
                }
                filtro += " f.cpf=:cpf ";
                parametros.put("cpf", obj.getCpf());
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
    public boolean Apagar(Funcionario obj) {
        try {
            Query query = manager.createQuery("Update funcionario s set s.ativo = 0 WHERE s.id :=id");
            query.setParameter("id", obj.getPessoaid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
