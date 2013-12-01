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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Mauro
 */
@Entity

public class Estoques implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "EstoqueID")
    private Integer estoqueID;
    @Column(name = "Quantidade")
    private int quantidade;
    @JoinColumn(name = "EstoqueID", referencedColumnName = "ProdutoID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produtos produtos;

    
    public Estoques(int quantidade, Produtos produtos){
        this.quantidade = quantidade;
        this.produtos = produtos;
    }
    
    public Estoques() {
        this.quantidade = 0;
        this.produtos = null;
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
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.estoqueID);
        hash = 53 * hash + this.quantidade;
        hash = 53 * hash + Objects.hashCode(this.produtos);
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
        final Estoques other = (Estoques) obj;
        if (!Objects.equals(this.estoqueID, other.estoqueID)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Estoques{" + "estoqueID=" + estoqueID + '}';
    }

    
    
}
