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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByNotaID", query = "SELECT n FROM Notas n WHERE n.notaID = :notaID")})
public class Notas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NotaID")
    private Integer notaID;
    @OneToMany(mappedBy = "notaID")
    private List<Entregas> entregasList;
    @JoinColumn(name = "VendaID", referencedColumnName = "VendaID")
    @ManyToOne
    private Vendas vendaID;

    public Notas() {
    }

    public Notas(Integer notaID) {
        this.notaID = notaID;
    }

    public Integer getNotaID() {
        return notaID;
    }

    public void setNotaID(Integer notaID) {
        this.notaID = notaID;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    public Vendas getVendaID() {
        return vendaID;
    }

    public void setVendaID(Vendas vendaID) {
        this.vendaID = vendaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notaID != null ? notaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.notaID == null && other.notaID != null) || (this.notaID != null && !this.notaID.equals(other.notaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Notas[ notaID=" + notaID + " ]";
    }
    
}
