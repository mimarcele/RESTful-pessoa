package com.codigolimpo.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class PessoaDto {
    @ApiModelProperty(value = "Código da pessoa")
    private Long id;
    private String nome;
    private List<EnderecoDto> enderecos;
}
