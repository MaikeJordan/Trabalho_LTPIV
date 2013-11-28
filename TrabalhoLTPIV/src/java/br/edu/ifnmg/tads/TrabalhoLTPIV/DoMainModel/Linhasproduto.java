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
@Table(name = "linhasproduto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhasproduto.findAll", query = "SELECT l FROM Linhasproduto l"),
    @NamedQuery(name = "Linhasproduto.findByLinhaProdutoID", query = "SELECT l FROM Linhasproduto l WHERE l.linhaProdutoID = :linhaProdutoID"),
    @NamedQuery(name = "Linhasproduto.findByNome", query = "SELECT l FROM Linhasproduto l WHERE l.nome = :nome")})
public class Linhasproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LinhaProdutoID")
    private Integer linhaProdutoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(mappedBy = "linhaProdutoId")
    private List<Produtos> produtosList;

    public Linhasproduto() {
    }

    public Linhasproduto(Integer linhaProdutoID) {
        this.linhaProdutoID = linhaProdutoID;
    }

    public Linhasproduto(Integer linhaProdutoID, String nome) {
        this.linhaProdutoID = linhaProdutoID;
        this.nome = nome;
    }

    public Integer getLinhaProdutoID() {
        return linhaProdutoID;
    }

    public void setLinhaProdutoID(Integer linhaProdutoID) {
        this.linhaProdutoID = linhaProdutoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (linhaProdutoID != null ? linhaProdutoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhasproduto)) {
            return false;
        }
        Linhasproduto other = (Linhasproduto) object;
        if ((this.linhaProdutoID == null && other.linhaProdutoID != null) || (this.linhaProdutoID != null && !this.linhaProdutoID.equals(other.linhaProdutoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Linhasproduto[ linhaProdutoID=" + linhaProdutoID + " ]";
    }
    
}
