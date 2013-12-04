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
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Vendaid;
    
    private int ativo;
    
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @NotNull
    @Column(name = "ValorTotal")
    private double valorTotal;

    @NotNull
    @Column(name = "Operacao")
    private int operacao;
    
    @OneToMany
    private List<ItemVenda> Itens;
    
    @ManyToOne
    private Cliente clienteID;
    
    @ManyToOne
    private Funcionario funcionarioID;

    public Venda(Long Vendaid, Date data, double valorTotal, int operacao, List<ItemVenda> itensvendaList, Cliente clienteID, Funcionario funcionarioID) {
        this.Vendaid = Vendaid;
        this.data = data;
        this.valorTotal = valorTotal;
        this.operacao = operacao;
        this.Itens = itensvendaList;
        this.clienteID = clienteID;
        this.funcionarioID = funcionarioID;
    }

    public Venda() {
        this.Vendaid = null;
        this.data = null;
        this.valorTotal = 0;
        this.operacao = 0;
        this.Itens = null;
        this.clienteID = null;
        this.funcionarioID = null;
    }
    public Long getVendaid() {
        return Vendaid;
    }

    public void setVendaid(Long id) {
        this.Vendaid = id;
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

    public List<ItemVenda> getItens() {
        return (List<ItemVenda>) Itens;
    }

    public void setItens(List<ItemVenda> Itens) {
        this.Itens = Itens;
    }

    public Cliente getClienteID() {
        return clienteID;
    }

    public void setClienteID(Cliente clienteID) {
        this.clienteID = clienteID;
    }

    public Funcionario getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Funcionario funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public void addItemVenda(ItemVenda item){
        if(!Itens.contains(item)){
            Itens.add(item);
        }
    }
    
    public void removeItemVenda(ItemVenda item){
        if(Itens.contains(item)){
            Itens.remove(item);
        }
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.Vendaid);
        hash = 71 * hash + this.ativo;
        hash = 71 * hash + Objects.hashCode(this.data);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 71 * hash + this.operacao;
        hash = 71 * hash + Objects.hashCode(this.Itens);
        hash = 71 * hash + Objects.hashCode(this.clienteID);
        hash = 71 * hash + Objects.hashCode(this.funcionarioID);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.Vendaid, other.Vendaid)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (this.operacao != other.operacao) {
            return false;
        }
        if (!Objects.equals(this.Itens, other.Itens)) {
            return false;
        }
        if (!Objects.equals(this.clienteID, other.clienteID)) {
            return false;
        }
        if (!Objects.equals(this.funcionarioID, other.funcionarioID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "Vendaid=" + Vendaid + '}';
    }

    
    
}
