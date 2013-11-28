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
@Table(name = "tiposfuncionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposfuncionario.findAll", query = "SELECT t FROM Tiposfuncionario t"),
    @NamedQuery(name = "Tiposfuncionario.findByTipoFuncionarioID", query = "SELECT t FROM Tiposfuncionario t WHERE t.tipoFuncionarioID = :tipoFuncionarioID"),
    @NamedQuery(name = "Tiposfuncionario.findByNome", query = "SELECT t FROM Tiposfuncionario t WHERE t.nome = :nome"),
    @NamedQuery(name = "Tiposfuncionario.findByDescricao", query = "SELECT t FROM Tiposfuncionario t WHERE t.descricao = :descricao")})
public class Tiposfuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TipoFuncionarioID")
    private Integer tipoFuncionarioID;
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
    @OneToMany(mappedBy = "tipoFuncionarioID")
    private List<Funcionarios> funcionariosList;

    public Tiposfuncionario() {
    }

    public Tiposfuncionario(Integer tipoFuncionarioID) {
        this.tipoFuncionarioID = tipoFuncionarioID;
    }

    public Tiposfuncionario(Integer tipoFuncionarioID, String nome, String descricao) {
        this.tipoFuncionarioID = tipoFuncionarioID;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getTipoFuncionarioID() {
        return tipoFuncionarioID;
    }

    public void setTipoFuncionarioID(Integer tipoFuncionarioID) {
        this.tipoFuncionarioID = tipoFuncionarioID;
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
    public List<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List<Funcionarios> funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoFuncionarioID != null ? tipoFuncionarioID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposfuncionario)) {
            return false;
        }
        Tiposfuncionario other = (Tiposfuncionario) object;
        if ((this.tipoFuncionarioID == null && other.tipoFuncionarioID != null) || (this.tipoFuncionarioID != null && !this.tipoFuncionarioID.equals(other.tipoFuncionarioID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Tiposfuncionario[ tipoFuncionarioID=" + tipoFuncionarioID + " ]";
    }
    
}
