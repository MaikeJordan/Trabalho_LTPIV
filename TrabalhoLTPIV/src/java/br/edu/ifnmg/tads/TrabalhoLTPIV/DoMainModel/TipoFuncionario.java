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
 * @author Desktop
 */
@Entity
public class TipoFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TipoFuncionarioid;
    
    private int ativo;
    
    @Column(name="nome", length = 255)
    private String nome;
    
    @Column(name="descricao", length = 255)
    private String descricao;

    public TipoFuncionario(Long TipoFuncionarioid, String nome, String descricao) {
        this.TipoFuncionarioid = TipoFuncionarioid;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public TipoFuncionario() {
        this.TipoFuncionarioid = null;
        this.nome = "";
        this.descricao = "";
    }

    public Long getTipoFuncionarioid() {
        return TipoFuncionarioid;
    }

    public void setTipoFuncionarioid(Long TipoFuncionarioid) {
        this.TipoFuncionarioid = TipoFuncionarioid;
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
        hash = 61 * hash + Objects.hashCode(this.TipoFuncionarioid);
        hash = 61 * hash + this.ativo;
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.descricao);
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
        final TipoFuncionario other = (TipoFuncionario) obj;
        if (!Objects.equals(this.TipoFuncionarioid, other.TipoFuncionarioid)) {
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
        return "TipoFuncionario{" + "nome=" + nome + '}';
    }

    
    
}
