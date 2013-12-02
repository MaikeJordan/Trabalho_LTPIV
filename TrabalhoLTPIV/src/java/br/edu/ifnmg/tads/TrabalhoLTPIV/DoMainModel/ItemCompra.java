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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Desktop
 */
@Entity
public class ItemCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ItemCompraid;
   
    @NotNull
    @Column(name = "Quantidade")
    private int quantidade;
    

    @OneToOne
    private Produtos produtoID;

    public ItemCompra(Long ItemCompraid, int quantidade, Produtos produtoID) {
        this.ItemCompraid = ItemCompraid;
        this.quantidade = quantidade;
        this.produtoID = produtoID;
    }

    public ItemCompra() {
        this.ItemCompraid = null;
        this.quantidade = 0;
        this.produtoID = null;
    }
    
    public Long getItemCompraid() {
        return ItemCompraid;
    }

    public void setItemCompraid(Long ItemCompraid) {
        this.ItemCompraid = ItemCompraid;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.ItemCompraid);
        hash = 97 * hash + this.quantidade;
        hash = 97 * hash + Objects.hashCode(this.produtoID);
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
        final ItemCompra other = (ItemCompra) obj;
        if (!Objects.equals(this.ItemCompraid, other.ItemCompraid)) {
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
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.ItemCompra[ id=" + ItemCompraid + " ]";
    }
    
}
