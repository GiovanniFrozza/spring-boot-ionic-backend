package com.giovanniEstudo.cursoMC.Entities;

import com.giovanniEstudo.cursoMC.enums.EstadoPagamentoEnum;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartaoEntity extends PagamentoEntity {

    private Integer numeroDeParcelas;

    public PagamentoComCartaoEntity(){

    }

    public PagamentoComCartaoEntity(Integer id, EstadoPagamentoEnum estadoPagamento, PedidoEntity pedido, Integer numeroDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }


}
