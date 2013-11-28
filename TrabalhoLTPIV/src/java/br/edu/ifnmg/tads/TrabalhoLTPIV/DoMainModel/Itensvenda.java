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
@Table(name = "itensvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itensvenda.findAll", query = "SELECT i FROM Itensvenda i"),
    @NamedQuery(name = "Itensvenda.findByItenVendaID", query = "SELECT i FROM Itensvenda i WHERE i.itenVendaID = :itenVendaID"),
    @NamedQuery(name = "Itensvenda.findByQuantidade", query = "SELECT i FROM Itensvenda i WHERE i.quantidade = :quantidade")})
public class Itensvenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ItenVendaID")
    private Integer itenVendaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    @JoinColumn(name = "VendaID", referencedColumnName = "VendaID")
    @ManyToOne
    private Vendas vendaID;
    @JoinColumn(name = "ProdutoID", referencedColumnName = "ProdutoID")
    @ManyToOne
    private Produtos produtoID;

    public Itensvenda() {
    }

    public Itensvenda(Integer itenVendaID) {
        this.itenVendaID = itenVendaID;
    }

    public Itensvenda(Integer itenVendaID, int quantidade) {
        this.itenVendaID = itenVendaID;
        this.quantidade = quantidade;
    }

    public Integer getItenVendaID() {
        return itenVendaID;
    }

    public void setItenVendaID(Integer itenVendaID) {
        this.itenVendaID = itenVendaID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Vendas getVendaID() {
        return vendaID;
    }

    public void setVendaID(Vendas vendaID) {
        this.vendaID = vendaID;
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
        hash += (itenVendaID != null ? itenVendaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itensvenda)) {
            return false;
        }
        Itensvenda other = (Itensvenda) object;
        if ((this.itenVendaID == null && other.itenVendaID != null) || (this.itenVendaID != null && !this.itenVendaID.equals(other.itenVendaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Itensvenda[ itenVendaID=" + itenVendaID + " ]";
    }
    
}
