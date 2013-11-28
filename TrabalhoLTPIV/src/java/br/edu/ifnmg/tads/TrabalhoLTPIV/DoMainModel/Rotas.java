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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "rotas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rotas.findAll", query = "SELECT r FROM Rotas r"),
    @NamedQuery(name = "Rotas.findByRotaID", query = "SELECT r FROM Rotas r WHERE r.rotaID = :rotaID"),
    @NamedQuery(name = "Rotas.findByDistancia", query = "SELECT r FROM Rotas r WHERE r.distancia = :distancia")})
public class Rotas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RotaID")
    private Integer rotaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Distancia")
    private int distancia;
    @JoinColumn(name = "CidadeDestinoID", referencedColumnName = "CidadeID")
    @ManyToOne
    private Cidades cidadeDestinoID;
    @JoinColumn(name = "CidadeOrigemID", referencedColumnName = "CidadeID")
    @ManyToOne
    private Cidades cidadeOrigemID;
    @OneToMany(mappedBy = "rotaID")
    private List<Entregas> entregasList;

    public Rotas() {
    }

    public Rotas(Integer rotaID) {
        this.rotaID = rotaID;
    }

    public Rotas(Integer rotaID, int distancia) {
        this.rotaID = rotaID;
        this.distancia = distancia;
    }

    public Integer getRotaID() {
        return rotaID;
    }

    public void setRotaID(Integer rotaID) {
        this.rotaID = rotaID;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Cidades getCidadeDestinoID() {
        return cidadeDestinoID;
    }

    public void setCidadeDestinoID(Cidades cidadeDestinoID) {
        this.cidadeDestinoID = cidadeDestinoID;
    }

    public Cidades getCidadeOrigemID() {
        return cidadeOrigemID;
    }

    public void setCidadeOrigemID(Cidades cidadeOrigemID) {
        this.cidadeOrigemID = cidadeOrigemID;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rotaID != null ? rotaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rotas)) {
            return false;
        }
        Rotas other = (Rotas) object;
        if ((this.rotaID == null && other.rotaID != null) || (this.rotaID != null && !this.rotaID.equals(other.rotaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Rotas[ rotaID=" + rotaID + " ]";
    }
    
}
