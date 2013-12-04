/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Desktop
 */
@Entity
public class Funcionario extends Pessoa implements Serializable {
    
    @ManyToOne
    private TipoFuncionario tipo;
    
    private int ativo;

    public Funcionario() {
        this.tipo = null;
    }

    public Funcionario(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + this.ativo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "tipo=" + tipo + '}';
    }

    
    
}
