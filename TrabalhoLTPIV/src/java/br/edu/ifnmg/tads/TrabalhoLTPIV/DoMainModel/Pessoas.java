/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "pessoas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoas.findAll", query = "SELECT p FROM Pessoas p"),
    @NamedQuery(name = "Pessoas.findByPessoaID", query = "SELECT p FROM Pessoas p WHERE p.pessoaID = :pessoaID"),
    @NamedQuery(name = "Pessoas.findByNome", query = "SELECT p FROM Pessoas p WHERE p.nome = :nome"),
    @NamedQuery(name = "Pessoas.findByRg", query = "SELECT p FROM Pessoas p WHERE p.rg = :rg"),
    @NamedQuery(name = "Pessoas.findByCpf", query = "SELECT p FROM Pessoas p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pessoas.findByDataNascimento", query = "SELECT p FROM Pessoas p WHERE p.dataNascimento = :dataNascimento")})
public class Pessoas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PessoaID")
    private Integer pessoaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPF")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoas")
    private Funcionarios funcionarios;
    @OneToMany(mappedBy = "pessoaID")
    private List<Telefones> telefonesList;
    @OneToMany(mappedBy = "pessoaID")
    private List<Enderecos> enderecosList;
    @OneToMany(mappedBy = "pessoaID")
    private List<Emails> emailsList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoas")
    private Clientes clientes;

    public Pessoas() {
    }

    public Pessoas(Integer pessoaID) {
        this.pessoaID = pessoaID;
    }

    public Pessoas(Integer pessoaID, String nome, String rg, String cpf, Date dataNascimento) {
        this.pessoaID = pessoaID;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(Integer pessoaID) {
        this.pessoaID = pessoaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    @XmlTransient
    public List<Telefones> getTelefonesList() {
        return telefonesList;
    }

    public void setTelefonesList(List<Telefones> telefonesList) {
        this.telefonesList = telefonesList;
    }

    @XmlTransient
    public List<Enderecos> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Enderecos> enderecosList) {
        this.enderecosList = enderecosList;
    }

    @XmlTransient
    public List<Emails> getEmailsList() {
        return emailsList;
    }

    public void setEmailsList(List<Emails> emailsList) {
        this.emailsList = emailsList;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaID != null ? pessoaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoas)) {
            return false;
        }
        Pessoas other = (Pessoas) object;
        if ((this.pessoaID == null && other.pessoaID != null) || (this.pessoaID != null && !this.pessoaID.equals(other.pessoaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Pessoas[ pessoaID=" + pessoaID + " ]";
    }
    
}
