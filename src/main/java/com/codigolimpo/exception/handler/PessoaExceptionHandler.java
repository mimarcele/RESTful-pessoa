package com.codigolimpo.exception.handler;

import com.codigolimpo.exception.PessoaNotFoundException;
import com.codigolimpo.exception.details.PessoaNotFoundDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class PessoaExceptionHandler {
    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<?> handlePessoaNotFoundException(PessoaNotFoundException e){
        PessoaNotFoundDetails notFoundDetails = PessoaNotFoundDetails.PessoaNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Pessoa não encontrada")
                .details(e.getMessage())
                .build();
        return new ResponseEntity<>(notFoundDetails, HttpStatus.NOT_FOUND);
    }
}
