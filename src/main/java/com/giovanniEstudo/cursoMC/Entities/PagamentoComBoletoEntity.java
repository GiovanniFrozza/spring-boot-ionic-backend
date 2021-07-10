package com.giovanniEstudo.cursoMC.Entities;

import com.giovanniEstudo.cursoMC.enums.EstadoPagamentoEnum;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoletoEntity extends PagamentoEntity {

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoletoEntity(){

    }

    public PagamentoComBoletoEntity(Integer id, EstadoPagamentoEnum estadoPagamento, Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
