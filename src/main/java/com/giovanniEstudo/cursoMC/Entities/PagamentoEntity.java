package com.giovanniEstudo.cursoMC.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.giovanniEstudo.cursoMC.enums.EstadoPagamentoEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PagamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private Integer estadoPagamento;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "pedidoEntity_id")
    @MapsId
    private PedidoEntity pedido;

    public PagamentoEntity(){

    }

    public PagamentoEntity(Integer id, EstadoPagamentoEnum estadoPagamento, PedidoEntity pedido) {
        this.id = id;
        this.estadoPagamento = estadoPagamento.getCodigo();
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstadoPagamento() {
        return EstadoPagamentoEnum.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamentoEnum estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCodigo();
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }
}

