/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Desktop
 */
@Entity
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Entregaid;
    
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @ManyToOne
    private Nota notaID;
    
    @ManyToOne
    private FrotaAutomovel frotaAutomovelID;
    
    @ManyToOne
    private Rotas rotaID;
    
    @ManyToOne
    private Funcionario funcionarioID;

    public Entrega(Long Entregaid, Date data, Nota notaID, FrotaAutomovel frotaAutomovelID, Rotas rotaID, Funcionario funcionarioID) {
        this.Entregaid = Entregaid;
        this.data = data;
        this.notaID = notaID;
        this.frotaAutomovelID = frotaAutomovelID;
        this.rotaID = rotaID;
        this.funcionarioID = funcionarioID;
    }
    
    public Entrega(){
        this.Entregaid = null;
        this.data = null;
        this.notaID = null;
        this.frotaAutomovelID = null;
        this.rotaID = null;
        this.funcionarioID = null;
    }

    public Long getEntregaid() {
        return Entregaid;
    }

    public void setEntregaid(Long Entregaid) {
        this.Entregaid = Entregaid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Nota getNotaID() {
        return notaID;
    }

    public void setNotaID(Nota notaID) {
        this.notaID = notaID;
    }

    public FrotaAutomovel getFrotaAutomovelID() {
        return frotaAutomovelID;
    }

    public void setFrotaAutomovelID(FrotaAutomovel frotaAutomovelID) {
        this.frotaAutomovelID = frotaAutomovelID;
    }

    public Rotas getRotaID() {
        return rotaID;
    }

    public void setRotaID(Rotas rotaID) {
        this.rotaID = rotaID;
    }

    public Funcionario getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Funcionario funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.Entregaid);
        hash = 59 * hash + Objects.hashCode(this.data);
        hash = 59 * hash + Objects.hashCode(this.notaID);
        hash = 59 * hash + Objects.hashCode(this.frotaAutomovelID);
        hash = 59 * hash + Objects.hashCode(this.rotaID);
        hash = 59 * hash + Objects.hashCode(this.funcionarioID);
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
        final Entrega other = (Entrega) obj;
        if (!Objects.equals(this.Entregaid, other.Entregaid)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.notaID, other.notaID)) {
            return false;
        }
        if (!Objects.equals(this.frotaAutomovelID, other.frotaAutomovelID)) {
            return false;
        }
        if (!Objects.equals(this.rotaID, other.rotaID)) {
            return false;
        }
        if (!Objects.equals(this.funcionarioID, other.funcionarioID)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Entrega[ id=" + Entregaid + " ]";
    }
    
}
