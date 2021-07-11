package com.giovanniEstudo.cursoMC.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class ProdutoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable( name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id") )
    private List<CategoriaEntity> categorias = new ArrayList<>();

    private Set<ItemPedidoEntity> itens = new HashSet<>();


    public ProdutoEntity() {

    }

    public ProdutoEntity(Integer id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public List<PedidoEntity> getPedidos() {
        List<PedidoEntity> lista = new ArrayList<>();
        for(ItemPedidoEntity itensPedidos : itens) {
            lista.add(itensPedidos.getPedido());
        }
        return lista;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<CategoriaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<CategoriaEntity> categorias) {
        this.categorias = categorias;
    }

    public Set<ItemPedidoEntity> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedidoEntity> itens) {
        this.itens = itens;
    }
}
