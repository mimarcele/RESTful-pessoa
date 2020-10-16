package com.codigolimpo.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnderecoDto {

    @ApiModelProperty(value = "Código do endereço")
    private Long id;

    private String endereco;

}
