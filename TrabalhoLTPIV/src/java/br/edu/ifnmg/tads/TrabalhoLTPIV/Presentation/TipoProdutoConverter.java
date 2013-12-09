/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ITipoprodutoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.TipoProduto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Maike
 */
@Named(value = "tipoProdutoConverter")
@SessionScoped
public class TipoProdutoConverter implements Serializable, Converter {

    /**
     * Creates a new instance of TipoProdutoConverter
     */
    ITipoprodutoRepositorio dao;
    
    public TipoProdutoConverter() {
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
            TipoProduto tp = (TipoProduto)value;
            return tp.getId().toString();
        } 
    }    
}
