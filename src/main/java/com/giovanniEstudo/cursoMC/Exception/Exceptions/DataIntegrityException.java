package com.giovanniEstudo.cursoMC.Exception.Exceptions;

public class DataIntegrityException extends RuntimeException {
    private static final long serialVresionUID = 1L;

    public DataIntegrityException() {
        super("Nao eh possivel excluir uma categoria que possui produtos.");
    }

}
