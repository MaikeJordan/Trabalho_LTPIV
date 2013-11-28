/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "entregas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregas.findAll", query = "SELECT e FROM Entregas e"),
    @NamedQuery(name = "Entregas.findByEntregaID", query = "SELECT e FROM Entregas e WHERE e.entregaID = :entregaID"),
    @NamedQuery(name = "Entregas.findByData", query = "SELECT e FROM Entregas e WHERE e.data = :data")})
public class Entregas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EntregaID")
    private Integer entregaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "NotaID", referencedColumnName = "NotaID")
    @ManyToOne
    private Notas notaID;
    @JoinColumn(name = "FrotaAutomovelID", referencedColumnName = "FrotaAutomovelID")
    @ManyToOne
    private Frotasautomoveis frotaAutomovelID;
    @JoinColumn(name = "RotaID", referencedColumnName = "RotaID")
    @ManyToOne
    private Rotas rotaID;
    @JoinColumn(name = "FuncionarioID", referencedColumnName = "FuncionarioID")
    @ManyToOne
    private Funcionarios funcionarioID;

    public Entregas() {
    }

    public Entregas(Integer entregaID) {
        this.entregaID = entregaID;
    }

    public Entregas(Integer entregaID, Date data) {
        this.entregaID = entregaID;
        this.data = data;
    }

    public Integer getEntregaID() {
        return entregaID;
    }

    public void setEntregaID(Integer entregaID) {
        this.entregaID = entregaID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Notas getNotaID() {
        return notaID;
    }

    public void setNotaID(Notas notaID) {
        this.notaID = notaID;
    }

    public Frotasautomoveis getFrotaAutomovelID() {
        return frotaAutomovelID;
    }

    public void setFrotaAutomovelID(Frotasautomoveis frotaAutomovelID) {
        this.frotaAutomovelID = frotaAutomovelID;
    }

    public Rotas getRotaID() {
        return rotaID;
    }

    public void setRotaID(Rotas rotaID) {
        this.rotaID = rotaID;
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
        hash += (entregaID != null ? entregaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregas)) {
            return false;
        }
        Entregas other = (Entregas) object;
        if ((this.entregaID == null && other.entregaID != null) || (this.entregaID != null && !this.entregaID.equals(other.entregaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Entregas[ entregaID=" + entregaID + " ]";
    }
    
}
