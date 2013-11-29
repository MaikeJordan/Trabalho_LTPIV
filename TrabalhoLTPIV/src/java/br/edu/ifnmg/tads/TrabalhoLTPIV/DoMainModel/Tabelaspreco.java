/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Mauro
 */
@Entity
public class Tabelaspreco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "PrecoSaida")
    private Double precosaida;
    @Column(name = "PrecoEntrada")
    private Double precoentrada;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DataCadastro")
    private Date datacadastro;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DataModificacao")
    private Date datamodificacao;
    @OneToOne
    @Column(name = "Produto")
    private Produtos produto;
    
    
    public Tabelaspreco(Double precosaida, Double precoentrada, Date datacadastro, Date datamodificacao, Produtos produto){
        this.precosaida = precosaida;
        this.precoentrada = precoentrada;
        this.datacadastro = datacadastro;
        this.datamodificacao = datamodificacao;
        this.produto = produto;
    }
    
    public Tabelaspreco(){
        this.precosaida = null;
        this.precoentrada = null;
        this.datacadastro = new Date();
        this.datamodificacao = new Date();
        this.produto = new Produtos();
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecosaida() {
        return precosaida;
    }

    public void setPrecosaida(Double precosaida) {
        this.precosaida = precosaida;
    }

    public Double getPrecoentrada() {
        return precoentrada;
    }

    public void setPrecoentrada(Double precoentrada) {
        this.precoentrada = precoentrada;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getDatamodificacao() {
        return datamodificacao;
    }

    public void setDatamodificacao(Date datamodificacao) {
        this.datamodificacao = datamodificacao;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.precosaida);
        hash = 67 * hash + Objects.hashCode(this.precoentrada);
        hash = 67 * hash + Objects.hashCode(this.datacadastro);
        hash = 67 * hash + Objects.hashCode(this.datamodificacao);
        hash = 67 * hash + Objects.hashCode(this.produto);
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
        final Tabelaspreco other = (Tabelaspreco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.precosaida, other.precosaida)) {
            return false;
        }
        if (!Objects.equals(this.precoentrada, other.precoentrada)) {
            return false;
        }
        if (!Objects.equals(this.datacadastro, other.datacadastro)) {
            return false;
        }
        if (!Objects.equals(this.datamodificacao, other.datamodificacao)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tabelaspreco{" + "id=" + id + '}';
    }

}
