package com.giovanniEstudo.cursoMC.Exception.handlers;

import com.giovanniEstudo.cursoMC.Exception.Exceptions.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class MethodArgumentNotValidHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerException(MethodArgumentNotValidHandler e) {
        return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
