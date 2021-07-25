package com.giovanniEstudo.cursoMC.Exception.Exceptions;

public class MethodArgumentNotValidException extends RuntimeException {
    private static final long serialVresionUID = 1L;

    public MethodArgumentNotValidException() {
        super("Valores invalidos");
    }
}