package com.codigolimpo.exception.handler;

import com.codigolimpo.exception.details.EnderecoNotFoundDetails;
import com.codigolimpo.exception.EnderecoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class EnderecoExceptionHandler {
    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<?> handleEnderecoNotFoundException(EnderecoNotFoundException e){
        EnderecoNotFoundDetails notFoundDetails = EnderecoNotFoundDetails.EnderecoNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Endereço não encontrado")
                .details(e.getMessage())
                .build();
        return new ResponseEntity<>(notFoundDetails, HttpStatus.NOT_FOUND);
    }
}
