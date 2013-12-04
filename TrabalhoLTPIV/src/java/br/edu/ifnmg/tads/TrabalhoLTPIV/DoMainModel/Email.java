/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Desktop
 */
@Entity
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Emailid;
    
    private int ativo;

    @Column(name="endereco", length=255)
    private String endereco;
    
    @ManyToOne
    private Pessoa pessoa;

    public Email(Long Emailid, String endereco, Pessoa pessoa) {
        this.Emailid = Emailid;
        this.endereco = endereco;
        this.pessoa = pessoa;
    }
    
    public Email() {
        this.Emailid = null;
        this.endereco = "";
        this.pessoa = null;
    }
    
    public Long getEmailid() {
        return Emailid;
    }
    

    public void setEmailid(Long Emailid) {
        this.Emailid = Emailid;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Emailid);
        hash = 67 * hash + this.ativo;
        hash = 67 * hash + Objects.hashCode(this.endereco);
        hash = 67 * hash + Objects.hashCode(this.pessoa);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.Emailid, other.Emailid)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" + "endereco=" + endereco + '}';
    }

    
    
}
