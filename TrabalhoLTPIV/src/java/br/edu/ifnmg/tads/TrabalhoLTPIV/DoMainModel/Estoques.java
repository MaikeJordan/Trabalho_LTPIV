/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "estoques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoques.findAll", query = "SELECT e FROM Estoques e"),
    @NamedQuery(name = "Estoques.findByEstoqueID", query = "SELECT e FROM Estoques e WHERE e.estoqueID = :estoqueID"),
    @NamedQuery(name = "Estoques.findByQuantidade", query = "SELECT e FROM Estoques e WHERE e.quantidade = :quantidade")})
public class Estoques implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EstoqueID")
    private Integer estoqueID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    @JoinColumn(name = "EstoqueID", referencedColumnName = "ProdutoID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produtos produtos;

    public Estoques() {
    }

    public Estoques(Integer estoqueID) {
        this.estoqueID = estoqueID;
    }

    public Estoques(Integer estoqueID, int quantidade) {
        this.estoqueID = estoqueID;
        this.quantidade = quantidade;
    }

    public Integer getEstoqueID() {
        return estoqueID;
    }

    public void setEstoqueID(Integer estoqueID) {
        this.estoqueID = estoqueID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estoqueID != null ? estoqueID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoques)) {
            return false;
        }
        Estoques other = (Estoques) object;
        if ((this.estoqueID == null && other.estoqueID != null) || (this.estoqueID != null && !this.estoqueID.equals(other.estoqueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Estoques[ estoqueID=" + estoqueID + " ]";
    }
    
}
