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
@Table(name = "tabelaspreco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tabelaspreco.findAll", query = "SELECT t FROM Tabelaspreco t"),
    @NamedQuery(name = "Tabelaspreco.findByTabelaPrecoID", query = "SELECT t FROM Tabelaspreco t WHERE t.tabelaPrecoID = :tabelaPrecoID"),
    @NamedQuery(name = "Tabelaspreco.findByPrecoSaida", query = "SELECT t FROM Tabelaspreco t WHERE t.precoSaida = :precoSaida"),
    @NamedQuery(name = "Tabelaspreco.findByPrecoEntrada", query = "SELECT t FROM Tabelaspreco t WHERE t.precoEntrada = :precoEntrada"),
    @NamedQuery(name = "Tabelaspreco.findByDataCadastro", query = "SELECT t FROM Tabelaspreco t WHERE t.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Tabelaspreco.findByDataModificacao", query = "SELECT t FROM Tabelaspreco t WHERE t.dataModificacao = :dataModificacao")})
public class Tabelaspreco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TabelaPrecoID")
    private Integer tabelaPrecoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoSaida")
    private double precoSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecoEntrada")
    private double precoEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataModificacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataModificacao;
    @JoinColumn(name = "ProdutoID", referencedColumnName = "ProdutoID")
    @ManyToOne
    private Produtos produtoID;

    public Tabelaspreco() {
    }

    public Tabelaspreco(Integer tabelaPrecoID) {
        this.tabelaPrecoID = tabelaPrecoID;
    }

    public Tabelaspreco(Integer tabelaPrecoID, double precoSaida, double precoEntrada, Date dataCadastro, Date dataModificacao) {
        this.tabelaPrecoID = tabelaPrecoID;
        this.precoSaida = precoSaida;
        this.precoEntrada = precoEntrada;
        this.dataCadastro = dataCadastro;
        this.dataModificacao = dataModificacao;
    }

    public Integer getTabelaPrecoID() {
        return tabelaPrecoID;
    }

    public void setTabelaPrecoID(Integer tabelaPrecoID) {
        this.tabelaPrecoID = tabelaPrecoID;
    }

    public double getPrecoSaida() {
        return precoSaida;
    }

    public void setPrecoSaida(double precoSaida) {
        this.precoSaida = precoSaida;
    }

    public double getPrecoEntrada() {
        return precoEntrada;
    }

    public void setPrecoEntrada(double precoEntrada) {
        this.precoEntrada = precoEntrada;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Produtos getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(Produtos produtoID) {
        this.produtoID = produtoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tabelaPrecoID != null ? tabelaPrecoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabelaspreco)) {
            return false;
        }
        Tabelaspreco other = (Tabelaspreco) object;
        if ((this.tabelaPrecoID == null && other.tabelaPrecoID != null) || (this.tabelaPrecoID != null && !this.tabelaPrecoID.equals(other.tabelaPrecoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Tabelaspreco[ tabelaPrecoID=" + tabelaPrecoID + " ]";
    }
    
}
