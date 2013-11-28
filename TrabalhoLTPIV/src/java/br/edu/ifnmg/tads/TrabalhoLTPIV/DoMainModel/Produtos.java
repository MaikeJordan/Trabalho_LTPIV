/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByProdutoID", query = "SELECT p FROM Produtos p WHERE p.produtoID = :produtoID"),
    @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtos.findByValorVenda", query = "SELECT p FROM Produtos p WHERE p.valorVenda = :valorVenda"),
    @NamedQuery(name = "Produtos.findByValorCompra", query = "SELECT p FROM Produtos p WHERE p.valorCompra = :valorCompra")})
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProdutoID")
    private Integer produtoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorVenda")
    private double valorVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorCompra")
    private double valorCompra;
    @JoinColumn(name = "LinhaProdutoId", referencedColumnName = "LinhaProdutoID")
    @ManyToOne
    private Linhasproduto linhaProdutoId;
    @JoinColumn(name = "TipoProdutoId", referencedColumnName = "TipoProdutoID")
    @ManyToOne
    private Tiposproduto tipoProdutoId;
    @OneToMany(mappedBy = "produtoID")
    private List<Itensvenda> itensvendaList;
    @OneToMany(mappedBy = "produtoID")
    private List<Itenscompra> itenscompraList;
    @OneToMany(mappedBy = "produtoID")
    private List<Tabelaspreco> tabelasprecoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produtos")
    private Estoques estoques;

    public Produtos() {
    }

    public Produtos(Integer produtoID) {
        this.produtoID = produtoID;
    }

    public Produtos(Integer produtoID, String nome, double valorVenda, double valorCompra) {
        this.produtoID = produtoID;
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
    }

    public Integer getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Integer produtoID) {
        this.produtoID = produtoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Linhasproduto getLinhaProdutoId() {
        return linhaProdutoId;
    }

    public void setLinhaProdutoId(Linhasproduto linhaProdutoId) {
        this.linhaProdutoId = linhaProdutoId;
    }

    public Tiposproduto getTipoProdutoId() {
        return tipoProdutoId;
    }

    public void setTipoProdutoId(Tiposproduto tipoProdutoId) {
        this.tipoProdutoId = tipoProdutoId;
    }

    @XmlTransient
    public List<Itensvenda> getItensvendaList() {
        return itensvendaList;
    }

    public void setItensvendaList(List<Itensvenda> itensvendaList) {
        this.itensvendaList = itensvendaList;
    }

    @XmlTransient
    public List<Itenscompra> getItenscompraList() {
        return itenscompraList;
    }

    public void setItenscompraList(List<Itenscompra> itenscompraList) {
        this.itenscompraList = itenscompraList;
    }

    @XmlTransient
    public List<Tabelaspreco> getTabelasprecoList() {
        return tabelasprecoList;
    }

    public void setTabelasprecoList(List<Tabelaspreco> tabelasprecoList) {
        this.tabelasprecoList = tabelasprecoList;
    }

    public Estoques getEstoques() {
        return estoques;
    }

    public void setEstoques(Estoques estoques) {
        this.estoques = estoques;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoID != null ? produtoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.produtoID == null && other.produtoID != null) || (this.produtoID != null && !this.produtoID.equals(other.produtoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Produtos[ produtoID=" + produtoID + " ]";
    }
    
}
