package com.giovanniEstudo.cursoMC.enums;

public enum TipoClienteEnum {
    PESSOAFISICA(1, "Pessoa fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private int codigo;
    private String descricao;

    TipoClienteEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoClienteEnum toEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }

        for(TipoClienteEnum tipoClientes : TipoClienteEnum.values()) {
            if(codigo.equals(tipoClientes.getCodigo())) {
                return tipoClientes;
            }
        }
        throw new IllegalArgumentException("id invalido");
    }

}