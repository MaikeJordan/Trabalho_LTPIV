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
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findByCidadeID", query = "SELECT c FROM Cidades c WHERE c.cidadeID = :cidadeID"),
    @NamedQuery(name = "Cidades.findByNome", query = "SELECT c FROM Cidades c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cidades.findByUf", query = "SELECT c FROM Cidades c WHERE c.uf = :uf")})
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CidadeID")
    private Integer cidadeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UF")
    private String uf;
    @OneToMany(mappedBy = "cidadeDestinoID")
    private List<Rotas> rotasList;
    @OneToMany(mappedBy = "cidadeOrigemID")
    private List<Rotas> rotasList1;

    public Cidades() {
    }

    public Cidades(Integer cidadeID) {
        this.cidadeID = cidadeID;
    }

    public Cidades(Integer cidadeID, String nome, String uf) {
        this.cidadeID = cidadeID;
        this.nome = nome;
        this.uf = uf;
    }

    public Integer getCidadeID() {
        return cidadeID;
    }

    public void setCidadeID(Integer cidadeID) {
        this.cidadeID = cidadeID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @XmlTransient
    public List<Rotas> getRotasList() {
        return rotasList;
    }

    public void setRotasList(List<Rotas> rotasList) {
        this.rotasList = rotasList;
    }

    @XmlTransient
    public List<Rotas> getRotasList1() {
        return rotasList1;
    }

    public void setRotasList1(List<Rotas> rotasList1) {
        this.rotasList1 = rotasList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidadeID != null ? cidadeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.cidadeID == null && other.cidadeID != null) || (this.cidadeID != null && !this.cidadeID.equals(other.cidadeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Cidades[ cidadeID=" + cidadeID + " ]";
    }
    
}
