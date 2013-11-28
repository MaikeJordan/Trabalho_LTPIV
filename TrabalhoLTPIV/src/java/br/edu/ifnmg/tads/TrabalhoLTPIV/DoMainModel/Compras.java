/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByCompraID", query = "SELECT c FROM Compras c WHERE c.compraID = :compraID"),
    @NamedQuery(name = "Compras.findByData", query = "SELECT c FROM Compras c WHERE c.data = :data"),
    @NamedQuery(name = "Compras.findByValorTotal", query = "SELECT c FROM Compras c WHERE c.valorTotal = :valorTotal"),
    @NamedQuery(name = "Compras.findByOperacao", query = "SELECT c FROM Compras c WHERE c.operacao = :operacao")})
public class Compras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CompraID")
    private Integer compraID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorTotal")
    private double valorTotal;
    @Column(name = "Operacao")
    private Integer operacao;
    @OneToMany(mappedBy = "compraID")
    private List<Itenscompra> itenscompraList;
    @JoinColumn(name = "FornecedorID", referencedColumnName = "FornecedorID")
    @ManyToOne
    private Fornecedores fornecedorID;
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID")
    @ManyToOne
    private Funcionarios funcionarioID;

    public Compras() {
    }

    public Compras(Integer compraID) {
        this.compraID = compraID;
    }

    public Compras(Integer compraID, Date data, double valorTotal) {
        this.compraID = compraID;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getCompraID() {
        return compraID;
    }

    public void setCompraID(Integer compraID) {
        this.compraID = compraID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getOperacao() {
        return operacao;
    }

    public void setOperacao(Integer operacao) {
        this.operacao = operacao;
    }

    @XmlTransient
    public List<Itenscompra> getItenscompraList() {
        return itenscompraList;
    }

    public void setItenscompraList(List<Itenscompra> itenscompraList) {
        this.itenscompraList = itenscompraList;
    }

    public Fornecedores getFornecedorID() {
        return fornecedorID;
    }

    public void setFornecedorID(Fornecedores fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    public Funcionarios getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Funcionarios funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraID != null ? compraID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.compraID == null && other.compraID != null) || (this.compraID != null && !this.compraID.equals(other.compraID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Compras[ compraID=" + compraID + " ]";
    }
    
}
