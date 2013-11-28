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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f"),
    @NamedQuery(name = "Funcionarios.findByFuncionarioID", query = "SELECT f FROM Funcionarios f WHERE f.funcionarioID = :funcionarioID")})
public class Funcionarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FuncionarioID")
    private Integer funcionarioID;
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "PessoaID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoas pessoas;
    @JoinColumn(name = "TipoFuncionarioID", referencedColumnName = "TipoFuncionarioID")
    @ManyToOne
    private Tiposfuncionario tipoFuncionarioID;
    @OneToMany(mappedBy = "funcionarioID")
    private List<Entregas> entregasList;
    @OneToMany(mappedBy = "funcionarioID")
    private List<Vendas> vendasList;
    @OneToMany(mappedBy = "funcionarioID")
    private List<Compras> comprasList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "funcionarios")
    private Usuarios usuarios;

    public Funcionarios() {
    }

    public Funcionarios(Integer funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public Integer getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Integer funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    public Tiposfuncionario getTipoFuncionarioID() {
        return tipoFuncionarioID;
    }

    public void setTipoFuncionarioID(Tiposfuncionario tipoFuncionarioID) {
        this.tipoFuncionarioID = tipoFuncionarioID;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    @XmlTransient
    public List<Vendas> getVendasList() {
        return vendasList;
    }

    public void setVendasList(List<Vendas> vendasList) {
        this.vendasList = vendasList;
    }

    @XmlTransient
    public List<Compras> getComprasList() {
        return comprasList;
    }

    public void setComprasList(List<Compras> comprasList) {
        this.comprasList = comprasList;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionarioID != null ? funcionarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.funcionarioID == null && other.funcionarioID != null) || (this.funcionarioID != null && !this.funcionarioID.equals(other.funcionarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Funcionarios[ funcionarioID=" + funcionarioID + " ]";
    }
    
}
