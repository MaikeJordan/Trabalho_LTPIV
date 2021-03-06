/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.FrotaAutomovel;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.IFrotasautomoveisRepositorio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author HERICK
 */
@Named(value = "frotaAutomovelConverter")
@SessionScoped
public class FrotaAutomovelConverter implements Serializable, Converter {

    /**
     * Creates a new instance of FrotaAutomovelConverter
     */
    @EJB
    IFrotasautomoveisRepositorio dao;

    public FrotaAutomovelConverter() {
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
        if (value == null || value.toString().equals("")) {
            return "";
        } else {
            FrotaAutomovel fa = (FrotaAutomovel) value;
            return fa.getFrotaAutomevelid().toString();
        }
    }

}
