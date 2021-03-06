package com.giovanniEstudo.cursoMC.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EstadoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<CidadeEntity> cidades = new ArrayList<>();

    public EstadoEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EstadoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CidadeEntity> getCidades() {
        return cidades;
    }

    public void setCidades(List<CidadeEntity> cidades) {
        this.cidades = cidades;
    }

}
