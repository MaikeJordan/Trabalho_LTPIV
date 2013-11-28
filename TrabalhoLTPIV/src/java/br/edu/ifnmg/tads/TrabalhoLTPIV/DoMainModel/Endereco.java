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
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Enderecoid;
    
    @Column(name="rua", length=255)
    private String rua;
    
    @Column(name="numero", length=255)
    private int numero;
    
    @Column(name="bairro", length=255)
    private String bairro;
    
    @Column(name="cidade", length=255)
    private String cidade;

    @Column(name="estado", length=255)
    private String estado;
    
    @Column(name="cep", length=255)
    private String CEP;
    
    @Column(name="complemento", length=255)
    private String complemento;
    
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name="pessoaid")
    private Pessoa pessoa;

    public Endereco(Long Enderecoid, String rua, int numero, String bairro, String cidade, String estado, String CEP, String complemento, Pessoa pessoa) {
        this.Enderecoid = Enderecoid;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
        this.complemento = complemento;
        this.pessoa = pessoa;
    }
    
    public Endereco() {
        this.Enderecoid = null;
        this.rua = "";
        this.numero = 0;
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.CEP = "";
        this.complemento = "";
        this.pessoa = null;
    }
    
    public Long getEnderecoid() {
        return Enderecoid;
    }

    public void setEnderecoid(Long Enderecoid) {
        this.Enderecoid = Enderecoid;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.Enderecoid);
        hash = 67 * hash + Objects.hashCode(this.rua);
        hash = 67 * hash + this.numero;
        hash = 67 * hash + Objects.hashCode(this.bairro);
        hash = 67 * hash + Objects.hashCode(this.cidade);
        hash = 67 * hash + Objects.hashCode(this.estado);
        hash = 67 * hash + Objects.hashCode(this.CEP);
        hash = 67 * hash + Objects.hashCode(this.complemento);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.Enderecoid, other.Enderecoid)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.CEP, other.CEP)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Endereco[ id=" + Enderecoid + " ]";
    }
    
}
