/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Desktop
 */
@Entity
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Telefoneid;
    
    @Column(name="numero", length=255)
    private String numero;
    
    @Column(name="ddd", length=255)
    private String ddd;
    
    @ManyToOne
    private Pessoa pessoa;

    public Telefone(Long Telefoneid, String numero, String ddd, Pessoa pessoa) {
        this.Telefoneid = Telefoneid;
        this.numero = numero;
        this.ddd = ddd;
        this.pessoa = pessoa;
    }
    
    public Telefone() {
        this.Telefoneid = null;
        this.numero = "";
        this.ddd = "";
        this.pessoa = null;
    }
    
    public Long getTelefoneid() {
        return Telefoneid;
    }

    public void setTelefoneid(Long Telefoneid) {
        this.Telefoneid = Telefoneid;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Telefoneid);
        hash = 67 * hash + Objects.hashCode(this.numero);
        hash = 67 * hash + Objects.hashCode(this.ddd);
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
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.Telefoneid, other.Telefoneid)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.ddd, other.ddd)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Telefone[ id=" + Telefoneid + " ]";
    }
    
}
