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
import javax.persistence.JoinColumn;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByClienteID", query = "SELECT c FROM Clientes c WHERE c.clienteID = :clienteID"),
    @NamedQuery(name = "Clientes.findByTipo", query = "SELECT c FROM Clientes c WHERE c.tipo = :tipo")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClienteID")
    private Integer clienteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Tipo")
    private String tipo;
    @JoinColumn(name = "ClienteID", referencedColumnName = "PessoaID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoas pessoas;
    @OneToMany(mappedBy = "clienteID")
    private List<Vendas> vendasList;

    public Clientes() {
    }

    public Clientes(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public Clientes(Integer clienteID, String tipo) {
        this.clienteID = clienteID;
        this.tipo = tipo;
    }

    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pessoas getPessoas() {
        return pessoas;
    }

    public void setPessoas(Pessoas pessoas) {
        this.pessoas = pessoas;
    }

    @XmlTransient
    public List<Vendas> getVendasList() {
        return vendasList;
    }

    public void setVendasList(List<Vendas> vendasList) {
        this.vendasList = vendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteID != null ? clienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.clienteID == null && other.clienteID != null) || (this.clienteID != null && !this.clienteID.equals(other.clienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Clientes[ clienteID=" + clienteID + " ]";
    }
    
}
