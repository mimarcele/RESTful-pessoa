package com.codigolimpo.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PessoaCreateException extends RuntimeException{
    public PessoaCreateException(String message){
        super(message);
    }

}
