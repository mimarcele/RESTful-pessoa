package com.codigolimpo.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PessoaUpdateException extends RuntimeException{
    public PessoaUpdateException(String message){
        super(message);
    }

}
