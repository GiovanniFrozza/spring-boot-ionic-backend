package com.giovanniEstudo.cursoMC.Exception.Exceptions;


public class ObjetoNaoEncontradoException extends RuntimeException {
    private static final long serialVresionUID = 1L;

    public ObjetoNaoEncontradoException() {
        super("Objeto nao encontrato.");
    }

}
