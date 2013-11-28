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
@Table(name = "frotasautomoveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frotasautomoveis.findAll", query = "SELECT f FROM Frotasautomoveis f"),
    @NamedQuery(name = "Frotasautomoveis.findByFrotaAutomovelID", query = "SELECT f FROM Frotasautomoveis f WHERE f.frotaAutomovelID = :frotaAutomovelID"),
    @NamedQuery(name = "Frotasautomoveis.findByNome", query = "SELECT f FROM Frotasautomoveis f WHERE f.nome = :nome"),
    @NamedQuery(name = "Frotasautomoveis.findByDescricao", query = "SELECT f FROM Frotasautomoveis f WHERE f.descricao = :descricao")})
public class Frotasautomoveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FrotaAutomovelID")
    private Integer frotaAutomovelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Descricao")
    private String descricao;
    @OneToMany(mappedBy = "frotaAutomovelID")
    private List<Entregas> entregasList;

    public Frotasautomoveis() {
    }

    public Frotasautomoveis(Integer frotaAutomovelID) {
        this.frotaAutomovelID = frotaAutomovelID;
    }

    public Frotasautomoveis(Integer frotaAutomovelID, String nome, String descricao) {
        this.frotaAutomovelID = frotaAutomovelID;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getFrotaAutomovelID() {
        return frotaAutomovelID;
    }

    public void setFrotaAutomovelID(Integer frotaAutomovelID) {
        this.frotaAutomovelID = frotaAutomovelID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash += (frotaAutomovelID != null ? frotaAutomovelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frotasautomoveis)) {
            return false;
        }
        Frotasautomoveis other = (Frotasautomoveis) object;
        if ((this.frotaAutomovelID == null && other.frotaAutomovelID != null) || (this.frotaAutomovelID != null && !this.frotaAutomovelID.equals(other.frotaAutomovelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Frotasautomoveis[ frotaAutomovelID=" + frotaAutomovelID + " ]";
    }
    
}
