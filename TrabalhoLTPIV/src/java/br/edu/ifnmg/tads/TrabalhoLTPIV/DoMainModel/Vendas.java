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
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByVendaID", query = "SELECT v FROM Vendas v WHERE v.vendaID = :vendaID"),
    @NamedQuery(name = "Vendas.findByData", query = "SELECT v FROM Vendas v WHERE v.data = :data"),
    @NamedQuery(name = "Vendas.findByValorTotal", query = "SELECT v FROM Vendas v WHERE v.valorTotal = :valorTotal"),
    @NamedQuery(name = "Vendas.findByOperacao", query = "SELECT v FROM Vendas v WHERE v.operacao = :operacao")})
public class Vendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VendaID")
    private Integer vendaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorTotal")
    private double valorTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Operacao")
    private int operacao;
    @OneToMany(mappedBy = "vendaID")
    private List<Itensvenda> itensvendaList;
    @OneToMany(mappedBy = "vendaID")
    private List<Notas> notasList;
    @JoinColumn(name = "ClienteID", referencedColumnName = "ClienteID")
    @ManyToOne
    private Clientes clienteID;
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID")
    @ManyToOne
    private Funcionarios funcionarioID;

    public Vendas() {
    }

    public Vendas(Integer vendaID) {
        this.vendaID = vendaID;
    }

    public Vendas(Integer vendaID, Date data, double valorTotal, int operacao) {
        this.vendaID = vendaID;
        this.data = data;
        this.valorTotal = valorTotal;
        this.operacao = operacao;
    }

    public Integer getVendaID() {
        return vendaID;
    }

    public void setVendaID(Integer vendaID) {
        this.vendaID = vendaID;
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

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    @XmlTransient
    public List<Itensvenda> getItensvendaList() {
        return itensvendaList;
    }

    public void setItensvendaList(List<Itensvenda> itensvendaList) {
        this.itensvendaList = itensvendaList;
    }

    @XmlTransient
    public List<Notas> getNotasList() {
        return notasList;
    }

    public void setNotasList(List<Notas> notasList) {
        this.notasList = notasList;
    }

    public Clientes getClienteID() {
        return clienteID;
    }

    public void setClienteID(Clientes clienteID) {
        this.clienteID = clienteID;
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
        hash += (vendaID != null ? vendaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.vendaID == null && other.vendaID != null) || (this.vendaID != null && !this.vendaID.equals(other.vendaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Vendas[ vendaID=" + vendaID + " ]";
    }
    
}
