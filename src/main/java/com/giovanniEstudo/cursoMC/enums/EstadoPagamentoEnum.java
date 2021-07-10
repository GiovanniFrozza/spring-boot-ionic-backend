package com.giovanniEstudo.cursoMC.enums;

public enum EstadoPagamentoEnum {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int codigo;
    private String descricao;

    EstadoPagamentoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamentoEnum toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }

        for(EstadoPagamentoEnum estadoPagamento : EstadoPagamentoEnum.values()) {
            if(codigo.equals(estadoPagamento.getCodigo())) {
                return estadoPagamento;
            }
        }
        throw new IllegalArgumentException("id invalido");
    }

}
