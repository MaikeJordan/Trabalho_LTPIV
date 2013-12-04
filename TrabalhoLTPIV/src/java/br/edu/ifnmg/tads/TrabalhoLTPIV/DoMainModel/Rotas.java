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
 * @author Mauro
 */
@Entity
public class Rotas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int ativo;
    
    @Column(name = "Distancia")
    private int distancia;
    @OneToOne
    private Cidades cidadeorigem;
    @OneToOne
    private Cidades cidadedestino;
    
    public Rotas(int distancia,Cidades cidadeorigem,Cidades cidadedestino ){
        this.distancia = distancia;
        this.cidadeorigem = cidadeorigem;
        this.cidadedestino = cidadedestino;
    }
    public Rotas(){
        this.distancia = 0;
        this.cidadeorigem = null;
        this.cidadedestino = null;
        
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Cidades getCidadeorigem() {
        return cidadeorigem;
    }

    public void setCidadeorigem(Cidades cidadeorigem) {
        this.cidadeorigem = cidadeorigem;
    }

    public Cidades getCidadedestino() {
        return cidadedestino;
    }

    public void setCidadedestino(Cidades cidadedestino) {
        this.cidadedestino = cidadedestino;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + this.ativo;
        hash = 89 * hash + this.distancia;
        hash = 89 * hash + Objects.hashCode(this.cidadeorigem);
        hash = 89 * hash + Objects.hashCode(this.cidadedestino);
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
        final Rotas other = (Rotas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if (this.distancia != other.distancia) {
            return false;
        }
        if (!Objects.equals(this.cidadeorigem, other.cidadeorigem)) {
            return false;
        }
        if (!Objects.equals(this.cidadedestino, other.cidadedestino)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rotas{" + "id=" + id + '}';
    }

    

    
}
