/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.TrabalhoLTPIV.DoMainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mauro
 */
@Entity
public class FrotaAutomovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FrotaAutomevelid;
    
    private int ativo;
    
    @Column(name = "Nome",length = 255)
    private String nome;
    
    @Column(name = "Descricao", length = 255)
    private String descricao;
    
    public FrotaAutomovel(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public FrotaAutomovel(){
        this.nome = "";
        this.descricao = "";
    }
    
    public Long getFrotaAutomevelid() {
        return FrotaAutomevelid;
    }

    public void setFrotaAutomevelid(Long FrotaAutomevelid) {
        this.FrotaAutomevelid = FrotaAutomevelid;
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

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.FrotaAutomevelid);
        hash = 41 * hash + this.ativo;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.descricao);
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
        final FrotaAutomovel other = (FrotaAutomovel) obj;
        if (!Objects.equals(this.FrotaAutomevelid, other.FrotaAutomevelid)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FrotaAutomovel{" + "nome=" + nome + '}';
    }

    
    
}
