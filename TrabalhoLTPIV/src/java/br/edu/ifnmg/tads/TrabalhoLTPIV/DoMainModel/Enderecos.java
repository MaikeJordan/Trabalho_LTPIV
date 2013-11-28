/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "enderecos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e"),
    @NamedQuery(name = "Enderecos.findByEnderecoID", query = "SELECT e FROM Enderecos e WHERE e.enderecoID = :enderecoID"),
    @NamedQuery(name = "Enderecos.findByRua", query = "SELECT e FROM Enderecos e WHERE e.rua = :rua"),
    @NamedQuery(name = "Enderecos.findByBairro", query = "SELECT e FROM Enderecos e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Enderecos.findByCidade", query = "SELECT e FROM Enderecos e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "Enderecos.findByEstado", query = "SELECT e FROM Enderecos e WHERE e.estado = :estado"),
    @NamedQuery(name = "Enderecos.findByCep", query = "SELECT e FROM Enderecos e WHERE e.cep = :cep"),
    @NamedQuery(name = "Enderecos.findByComplemento", query = "SELECT e FROM Enderecos e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Enderecos.findByNumero", query = "SELECT e FROM Enderecos e WHERE e.numero = :numero")})
public class Enderecos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EnderecoID")
    private Integer enderecoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Rua")
    private String rua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CEP")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Complemento")
    private String complemento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private int numero;
    @JoinColumn(name = "PessoaID", referencedColumnName = "PessoaID")
    @ManyToOne
    private Pessoas pessoaID;

    public Enderecos() {
    }

    public Enderecos(Integer enderecoID) {
        this.enderecoID = enderecoID;
    }

    public Enderecos(Integer enderecoID, String rua, String bairro, String cidade, String estado, String cep, String complemento, int numero) {
        this.enderecoID = enderecoID;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
    }

    public Integer getEnderecoID() {
        return enderecoID;
    }

    public void setEnderecoID(Integer enderecoID) {
        this.enderecoID = enderecoID;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoas getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(Pessoas pessoaID) {
        this.pessoaID = pessoaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoID != null ? enderecoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.enderecoID == null && other.enderecoID != null) || (this.enderecoID != null && !this.enderecoID.equals(other.enderecoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Enderecos[ enderecoID=" + enderecoID + " ]";
    }
    
}
