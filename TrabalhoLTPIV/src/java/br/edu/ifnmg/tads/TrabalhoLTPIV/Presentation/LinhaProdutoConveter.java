/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.Presentation;

import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ILinhasprodutoRepositorio;
import br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Linhasproduto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author HERICK
 */
@Named(value = "linhaProdutoConveter")
@SessionScoped
public class LinhaProdutoConveter implements Serializable, Converter {

    /**
     * Creates a new instance of LinhaProdutoConveter
     */
    ILinhasprodutoRepositorio dao;
    
    public LinhaProdutoConveter() {
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
            Linhasproduto lp = (Linhasproduto) value;
            return lp.getId().toString();
        }
    }
    
}
