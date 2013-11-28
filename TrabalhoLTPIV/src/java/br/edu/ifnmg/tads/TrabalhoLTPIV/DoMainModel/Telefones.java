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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "telefones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefones.findAll", query = "SELECT t FROM Telefones t"),
    @NamedQuery(name = "Telefones.findByTelefoneID", query = "SELECT t FROM Telefones t WHERE t.telefoneID = :telefoneID"),
    @NamedQuery(name = "Telefones.findByNumero", query = "SELECT t FROM Telefones t WHERE t.numero = :numero"),
    @NamedQuery(name = "Telefones.findByDdd", query = "SELECT t FROM Telefones t WHERE t.ddd = :ddd")})
public class Telefones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TelefoneID")
    private Integer telefoneID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DDD")
    private int ddd;
    @JoinColumn(name = "PessoaID", referencedColumnName = "PessoaID")
    @ManyToOne
    private Pessoas pessoaID;

    public Telefones() {
    }

    public Telefones(Integer telefoneID) {
        this.telefoneID = telefoneID;
    }

    public Telefones(Integer telefoneID, int numero, int ddd) {
        this.telefoneID = telefoneID;
        this.numero = numero;
        this.ddd = ddd;
    }

    public Integer getTelefoneID() {
        return telefoneID;
    }

    public void setTelefoneID(Integer telefoneID) {
        this.telefoneID = telefoneID;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
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
        hash += (telefoneID != null ? telefoneID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefones)) {
            return false;
        }
        Telefones other = (Telefones) object;
        if ((this.telefoneID == null && other.telefoneID != null) || (this.telefoneID != null && !this.telefoneID.equals(other.telefoneID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Telefones[ telefoneID=" + telefoneID + " ]";
    }
    
}
