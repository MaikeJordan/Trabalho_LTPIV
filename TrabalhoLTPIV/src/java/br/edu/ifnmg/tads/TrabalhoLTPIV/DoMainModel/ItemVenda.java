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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Desktop
 */
@Entity
public class ItemVenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ItemVendaid;
    
    @Column(name = "Quantidade")
    private int quantidade;
  
    @JoinColumn(name = "ProdutoID", referencedColumnName = "ProdutoID")
    @ManyToOne
    private Produtos produtoID;

    public ItemVenda(Long ItemVendaid, int quantidade, Produtos produtoID) {
        this.ItemVendaid = ItemVendaid;
        this.quantidade = quantidade;
        this.produtoID = produtoID;
    }
    
    public ItemVenda() {
        this.ItemVendaid = null;
        this.quantidade = 0;
        this.produtoID = null;
    }

    public Long getItemVendaid() {
        return ItemVendaid;
    }

    public void setItemVendaid(Long ItemVendaid) {
        this.ItemVendaid = ItemVendaid;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Produtos produtoID) {
        this.produtoID = produtoID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.ItemVendaid);
        hash = 89 * hash + this.quantidade;
        hash = 89 * hash + Objects.hashCode(this.produtoID);
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.ItemVendaid, other.ItemVendaid)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produtoID, other.produtoID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ItemVenda[ id=" + ItemVendaid + " ]";
    }
    
}
