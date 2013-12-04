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
import javax.persistence.OneToOne;

/**
 *
 * @author Desktop
 */
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Usuarioid;
    
    private int ativo;
    
    @OneToOne
    private Funcionario funcionario;
    
    @Column(name="login", length = 20)
    private String login;
    
    @Column(name="senha", length = 20)
    private String senha;

    public Usuario(Long Usuarioid, Funcionario funcionario, String login, String senha) {
        this.Usuarioid = Usuarioid;
        this.funcionario = funcionario;
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario() {
        this.Usuarioid = null;
        this.funcionario = null;
        this.login = "";
        this.senha = "";
    }

    public Long getUsuarioid() {
        return Usuarioid;
    }

    public void setUsuarioid(Long Usuarioid) {
        this.Usuarioid = Usuarioid;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.Usuarioid);
        hash = 89 * hash + this.ativo;
        hash = 89 * hash + Objects.hashCode(this.funcionario);
        hash = 89 * hash + Objects.hashCode(this.login);
        hash = 89 * hash + Objects.hashCode(this.senha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Usuarioid, other.Usuarioid)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Usuarioid=" + Usuarioid + '}';
    }

    
    
}
