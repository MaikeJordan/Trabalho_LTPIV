/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Desktop
 */
@Entity
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Compraid;

    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @NotNull
    @Column(name = "ValorTotal")
    private double valorTotal;
    
    @Column(name = "Operacao")
    private Integer operacao;
    
    @OneToMany(mappedBy = "compraID")
    private List<ItemCompra> Itens;
    
    @JoinColumn(name = "FornecedorID", referencedColumnName = "FornecedorID")
    @ManyToOne
    private Fornecedor fornecedorID;
    
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID")
    @ManyToOne
    private Funcionario funcionarioID;

    public Compra(Long Compraid, Date data, double valorTotal, Integer operacao, List<ItemCompra> itenscompraList, Fornecedor fornecedorID, Funcionario funcionarioID) {
        this.Compraid = Compraid;
        this.data = data;
        this.valorTotal = valorTotal;
        this.operacao = operacao;
        this.Itens = itenscompraList;
        this.fornecedorID = fornecedorID;
        this.funcionarioID = funcionarioID;
    }
    
    public Compra() {
        this.Compraid = null;
        this.data = null;
        this.valorTotal = 0;
        this.operacao = 0;
        this.Itens = null;
        this.fornecedorID = null;
        this.funcionarioID = null;
    }
    
    public Long getCompraid() {
        return Compraid;
    }

    public void setCompraid(Long Compraid) {
        this.Compraid = Compraid;
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

    public List<ItemCompra> getItenscompraList() {
        return Itens;
    }

    public void setItenscompraList(List<ItemCompra> itenscompraList) {
        this.Itens = itenscompraList;
    }

    public Fornecedor getFornecedorID() {
        return fornecedorID;
    }

    public void setFornecedorID(Fornecedor fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    public Funcionario getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Funcionario funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public void addItemCompra(ItemCompra item){
        if(!Itens.contains(item)){
            Itens.add(item);
        }
    }
    
    public void removeItemCompra(ItemCompra item){
        if(Itens.contains(item)){
            Itens.remove(item);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.Compraid);
        hash = 37 * hash + Objects.hashCode(this.data);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.operacao);
        hash = 37 * hash + Objects.hashCode(this.Itens);
        hash = 37 * hash + Objects.hashCode(this.fornecedorID);
        hash = 37 * hash + Objects.hashCode(this.funcionarioID);
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.Compraid, other.Compraid)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.operacao, other.operacao)) {
            return false;
        }
        if (!Objects.equals(this.Itens, other.Itens)) {
            return false;
        }
        if (!Objects.equals(this.fornecedorID, other.fornecedorID)) {
            return false;
        }
        if (!Objects.equals(this.funcionarioID, other.funcionarioID)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Compra[ id=" + Compraid + " ]";
    }
    
}
