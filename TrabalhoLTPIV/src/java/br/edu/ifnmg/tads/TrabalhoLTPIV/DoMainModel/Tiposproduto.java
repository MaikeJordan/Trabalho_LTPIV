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
@Table(name = "tiposproduto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposproduto.findAll", query = "SELECT t FROM Tiposproduto t"),
    @NamedQuery(name = "Tiposproduto.findByTipoProdutoID", query = "SELECT t FROM Tiposproduto t WHERE t.tipoProdutoID = :tipoProdutoID"),
    @NamedQuery(name = "Tiposproduto.findByNome", query = "SELECT t FROM Tiposproduto t WHERE t.nome = :nome"),
    @NamedQuery(name = "Tiposproduto.findByDescricao", query = "SELECT t FROM Tiposproduto t WHERE t.descricao = :descricao")})
public class Tiposproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipoProdutoID")
    private Integer tipoProdutoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Descricao")
    private String descricao;
    @OneToMany(mappedBy = "tipoProdutoId")
    private List<Produtos> produtosList;

    public Tiposproduto() {
    }

    public Tiposproduto(Integer tipoProdutoID) {
        this.tipoProdutoID = tipoProdutoID;
    }

    public Tiposproduto(Integer tipoProdutoID, String nome, String descricao) {
        this.tipoProdutoID = tipoProdutoID;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getTipoProdutoID() {
        return tipoProdutoID;
    }

    public void setTipoProdutoID(Integer tipoProdutoID) {
        this.tipoProdutoID = tipoProdutoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Produtos> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produtos> produtosList) {
        this.produtosList = produtosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoProdutoID != null ? tipoProdutoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposproduto)) {
            return false;
        }
        Tiposproduto other = (Tiposproduto) object;
        if ((this.tipoProdutoID == null && other.tipoProdutoID != null) || (this.tipoProdutoID != null && !this.tipoProdutoID.equals(other.tipoProdutoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Tiposproduto[ tipoProdutoID=" + tipoProdutoID + " ]";
    }
    
}
