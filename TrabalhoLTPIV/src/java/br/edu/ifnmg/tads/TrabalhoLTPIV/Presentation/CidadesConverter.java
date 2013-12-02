/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Cidades;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ICidadesRepositorio;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Converter;

/**
 *
 * @author Mauro
 */
@Named(value = "cidadesConverter")
@ViewScoped
public class CidadesConverter implements Serializable, Converter{

    /**
     * Creates a new instance of CidadesConverter
     */
    @EJB
    ICidadesRepositorio dao;
    
    public CidadesConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().equals("")) {
            return null;
        } else {
            Long id = Long.parseLong(value);
            return dao.Abrir(id);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.toString().equals("")){
            return "";
        } else{
            Cidades c = (Cidades)value;
            return c.getId().toString();
        } 
    }
}
