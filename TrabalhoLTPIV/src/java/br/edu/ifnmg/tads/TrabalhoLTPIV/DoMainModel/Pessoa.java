/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Desktop
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Pessoaid;
    
    @Column(name="nome", length = 255)
    private String nome;
    
    @Column(name="rg", length = 12 )
    private String rg;
    
    @Column(name="cpf", length = 12)
    private String cpf;
    
    @Column(name="datanascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datanascimento;
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="pessoaid") 
    private List<Email> emails;
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="pessoaid") 
    private List<Endereco> enderecos;
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="pessoaid") 
    private List<Telefone> telefones;

    public Pessoa(Long Pessoaid, String nome, String rg, String cpf, Date datanascimento, List<Email> emails, List<Endereco> enderecos, List<Telefone> telefones) {
        this.Pessoaid = Pessoaid;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.emails = emails;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }
    
    public Pessoa() {
        this.Pessoaid = null;
        this.nome = "";
        this.rg = "";
        this.cpf = "";
        this.datanascimento = null;
        this.emails = null;
        this.enderecos = null;
        this.telefones = null;
    }
    
    public Long getPessoaid() {
        return Pessoaid;
    }

    public void setPessoaid(Long id) {
        this.Pessoaid = id;
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

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public List<Email> getEmail() {
        return emails;
    }

    public void setEmail(List<Email> emails) {
        this.emails = emails;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public void addTelefone(Telefone telefone){
        if(!telefones.contains(telefone)){
            telefones.add(telefone);
        }
    }
    
    public void addEmail(Email email){
        if(!emails.contains(email)){
            emails.add(email);
        }
    }
    
    public void addEndereco(Endereco endereco){
        if(!enderecos.contains(endereco)){
            enderecos.add(endereco);
        }
    }
    
    public void removeTelefone(Telefone telefone){
        if(telefones.contains(telefone)){
            telefones.remove(telefone);
        }
    }
    
    public void removeEndereco(Endereco endereco){
        if(enderecos.contains(endereco)){
            enderecos.remove(endereco);
        }
    }
    
    public void removeEmail(Email email){
        if(emails.contains(email)){
            emails.remove(email);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Pessoaid);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.rg);
        hash = 53 * hash + Objects.hashCode(this.cpf);
        hash = 53 * hash + Objects.hashCode(this.datanascimento);
        hash = 53 * hash + Objects.hashCode(this.emails);
        hash = 53 * hash + Objects.hashCode(this.enderecos);
        hash = 53 * hash + Objects.hashCode(this.telefones);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.Pessoaid, other.Pessoaid)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.datanascimento, other.datanascimento)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
    
}
