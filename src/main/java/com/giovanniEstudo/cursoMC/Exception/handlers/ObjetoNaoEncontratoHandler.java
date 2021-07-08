package com.giovanniEstudo.cursoMC.Exception.handlers;

import com.giovanniEstudo.cursoMC.Exception.Exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ObjetoNaoEncontratoHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity handlerException(ObjetoNaoEncontratoHandler e) {
        return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
