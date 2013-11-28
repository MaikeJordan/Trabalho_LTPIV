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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desktop
 */
@Entity
@Table(name = "emails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emails.findAll", query = "SELECT e FROM Emails e"),
    @NamedQuery(name = "Emails.findByEmailID", query = "SELECT e FROM Emails e WHERE e.emailID = :emailID"),
    @NamedQuery(name = "Emails.findByEnderecoEmail", query = "SELECT e FROM Emails e WHERE e.enderecoEmail = :enderecoEmail")})
public class Emails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmailID")
    private Integer emailID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EnderecoEmail")
    private String enderecoEmail;
    @JoinColumn(name = "PessoaID", referencedColumnName = "PessoaID")
    @ManyToOne
    private Pessoas pessoaID;

    public Emails() {
    }

    public Emails(Integer emailID) {
        this.emailID = emailID;
    }

    public Emails(Integer emailID, String enderecoEmail) {
        this.emailID = emailID;
        this.enderecoEmail = enderecoEmail;
    }

    public Integer getEmailID() {
        return emailID;
    }

    public void setEmailID(Integer emailID) {
        this.emailID = emailID;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
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
        hash += (emailID != null ? emailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.emailID == null && other.emailID != null) || (this.emailID != null && !this.emailID.equals(other.emailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel.Emails[ emailID=" + emailID + " ]";
    }
    
}
