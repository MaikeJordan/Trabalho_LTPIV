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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "itenscompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itenscompra.findAll", query = "SELECT i FROM Itenscompra i"),
    @NamedQuery(name = "Itenscompra.findByItenCompraID", query = "SELECT i FROM Itenscompra i WHERE i.itenCompraID = :itenCompraID"),
    @NamedQuery(name = "Itenscompra.findByQuantidade", query = "SELECT i FROM Itenscompra i WHERE i.quantidade = :quantidade")})
public class Itenscompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ItenCompraID")
    private Integer itenCompraID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    @JoinColumn(name = "CompraID", referencedColumnName = "CompraID")
    @ManyToOne
    private Compras compraID;
    @JoinColumn(name = "ProdutoID", referencedColumnName = "ProdutoID")
    @ManyToOne
    private Produtos produtoID;

    public Itenscompra() {
    }

    public Itenscompra(Integer itenCompraID) {
        this.itenCompraID = itenCompraID;
    }

    public Itenscompra(Integer itenCompraID, int quantidade) {
        this.itenCompraID = itenCompraID;
        this.quantidade = quantidade;
    }

    public Integer getItenCompraID() {
        return itenCompraID;
    }

    public void setItenCompraID(Integer itenCompraID) {
        this.itenCompraID = itenCompraID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Compras getCompraID() {
        return compraID;
    }

    public void setCompraID(Compras compraID) {
        this.compraID = compraID;
    }

    public Produtos getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Produtos produtoID) {
        this.produtoID = produtoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itenCompraID != null ? itenCompraID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itenscompra)) {
            return false;
        }
        Itenscompra other = (Itenscompra) object;
        if ((this.itenCompraID == null && other.itenCompraID != null) || (this.itenCompraID != null && !this.itenCompraID.equals(other.itenCompraID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Itenscompra[ itenCompraID=" + itenCompraID + " ]";
    }
    
}
