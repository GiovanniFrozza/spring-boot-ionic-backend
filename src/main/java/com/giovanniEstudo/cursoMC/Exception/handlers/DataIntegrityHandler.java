package com.giovanniEstudo.cursoMC.Exception.handlers;

import com.giovanniEstudo.cursoMC.Exception.Exceptions.DataIntegrityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class DataIntegrityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity handlerException(DataIntegrityHandler e) {
        return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
