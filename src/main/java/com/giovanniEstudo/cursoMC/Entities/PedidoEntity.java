package com.giovanniEstudo.cursoMC.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PedidoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido") // erro aqui talvez
    private PagamentoEntity pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entraga_id")
    private EnderecoEntity endereco;

    public PedidoEntity(Integer id, Date instante) {
        this.id = id;
        this.instante = instante;
    }

    public PedidoEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public PagamentoEntity getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoEntity pagamento) {
        this.pagamento = pagamento;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
