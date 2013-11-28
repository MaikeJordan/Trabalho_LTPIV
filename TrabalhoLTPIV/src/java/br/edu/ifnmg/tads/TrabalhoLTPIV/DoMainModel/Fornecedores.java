/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByFornecedorID", query = "SELECT f FROM Fornecedores f WHERE f.fornecedorID = :fornecedorID"),
    @NamedQuery(name = "Fornecedores.findByNome", query = "SELECT f FROM Fornecedores f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedores.findByCnpj", query = "SELECT f FROM Fornecedores f WHERE f.cnpj = :cnpj")})
public class Fornecedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FornecedorID")
    private Integer fornecedorID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CNPJ")
    private String cnpj;
    @OneToMany(mappedBy = "fornecedorID")
    private List<Compras> comprasList;

    public Fornecedores() {
    }

    public Fornecedores(Integer fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    public Fornecedores(Integer fornecedorID, String nome, String cnpj) {
        this.fornecedorID = fornecedorID;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Integer getFornecedorID() {
        return fornecedorID;
    }

    public void setFornecedorID(Integer fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornecedorID != null ? fornecedorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.fornecedorID == null && other.fornecedorID != null) || (this.fornecedorID != null && !this.fornecedorID.equals(other.fornecedorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Fornecedores[ fornecedorID=" + fornecedorID + " ]";
    }
    
}
