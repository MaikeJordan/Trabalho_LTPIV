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
import javax.persistence.ManyToOne;

/**
 *
 * @author Mauro
 */
@Entity
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ProdutoID;
    
    @Column(name = "Nome", length = 255)
    private String nome;
    
    @Column(name = "ValorVenda")
    private Double valorvenda;
    
    @Column(name = "ValorCompra")
    private Double valorcompra;
    
    @ManyToOne
    private TipoProduto tipoproduto;
    
    @ManyToOne
    private Linhasproduto linhaproduto;
    
    public Produtos(Double valorvenda, Double valorcompra,TipoProduto tipoproduto,Linhasproduto linhaproduto){
        this.valorvenda = valorvenda;
        this.valorcompra = valorcompra;
        this.tipoproduto = tipoproduto;
        this.linhaproduto = linhaproduto;
    }
    
    
    public Produtos(){
        this.valorvenda = null;
        this.valorcompra = null;
        this.tipoproduto = null;
        this.linhaproduto = null;
    }
    
    public Long getProdutoID() {
        return ProdutoID;
    }

    public void setProdutoID(Long ProdutoID) {
        this.ProdutoID = ProdutoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(Double valorvenda) {
        this.valorvenda = valorvenda;
    }

    public Double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(Double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public TipoProduto getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(TipoProduto tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public Linhasproduto getLinhaproduto() {
        return linhaproduto;
    }

    public void setLinhaproduto(Linhasproduto linhaproduto) {
        this.linhaproduto = linhaproduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.ProdutoID);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.valorvenda);
        hash = 83 * hash + Objects.hashCode(this.valorcompra);
        hash = 83 * hash + Objects.hashCode(this.tipoproduto);
        hash = 83 * hash + Objects.hashCode(this.linhaproduto);
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
        final Produtos other = (Produtos) obj;
        if (!Objects.equals(this.ProdutoID, other.ProdutoID)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.valorvenda, other.valorvenda)) {
            return false;
        }
        if (!Objects.equals(this.valorcompra, other.valorcompra)) {
            return false;
        }
        if (!Objects.equals(this.tipoproduto, other.tipoproduto)) {
            return false;
        }
        if (!Objects.equals(this.linhaproduto, other.linhaproduto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produtos{" + "id=" + ProdutoID + '}';
    }

    
}
