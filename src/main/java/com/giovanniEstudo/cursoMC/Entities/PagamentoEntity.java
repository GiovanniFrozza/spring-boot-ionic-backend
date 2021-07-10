package com.giovanniEstudo.cursoMC.Entities;

import com.giovanniEstudo.cursoMC.enums.EstadoPagamentoEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PagamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private EstadoPagamentoEnum estadoPagamento;

    @OneToOne
    @JoinColumn(name = "pedidoEntity_id")
    @MapsId
    private PedidoEntity pedido;

    public PagamentoEntity(){

    }

    public PagamentoEntity(Integer id, EstadoPagamentoEnum estadoPagamento) {
        this.id = id;
        this.estadoPagamento = estadoPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstadoPagamento() {
        return estadoPagamento;
    }

    public void setEstadoPagamento(EstadoPagamentoEnum estadoPagamento) {
        this.estadoPagamento = estadoPagamento;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }
}

