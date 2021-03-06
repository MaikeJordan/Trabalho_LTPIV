/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DataAccess;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.FrotaAutomovel;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFrotasautomoveisRepositorio;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mauro
 */
@Stateless(name = "IfrotasautomoveisRepositorio")
public class FrotasautomoveisDAO extends DAOGenerico<FrotaAutomovel> implements IFrotasautomoveisRepositorio{
    
    public FrotasautomoveisDAO(){
        super(FrotaAutomovel.class);
    }
    
    @Override
    public List<FrotaAutomovel> Buscar(FrotaAutomovel obj) {
       // Corpo da consulta
        String consulta = "select f from frotasautomoveis f";

        // A parte where da consulta
        String filtro = "";

        // Guarda a lista de parâmetros da query
        HashMap<String, Object> parametros = new HashMap<String, Object>();

        // Verifica campo por campo os valores que serão filtrados
        if (obj != null) {
            //Nome
            if (obj.getNome() != null && obj.getNome().length() > 0) {
                
                filtro += " f.nome like '%"+obj.getNome()+"%' ";
               // parametros.put("nome", obj.getNome());
            }
            //Id
            if (obj.getFrotaAutomevelid() != null && obj.getFrotaAutomevelid() > 0) {
                
                filtro += " f.FrotaAutomovelid ="+obj.getFrotaAutomevelid();
                //parametros.put("id", obj.getFrotaAutomevelid());
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
    public boolean Apagar(FrotaAutomovel obj) {
         try {

            Query query = manager.createQuery("Update frotasautomoveis s set s.ativo = 0 WHERE s.FrotaAutomovelid :=FrotaAutomovelid");
            query.setParameter("FrotaAutomovelid", obj.getFrotaAutomevelid());
            query.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }
}
