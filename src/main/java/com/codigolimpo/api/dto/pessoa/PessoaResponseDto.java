package com.codigolimpo.api.dto.pessoa;

import com.codigolimpo.api.dto.endereco.EnderecoResponseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class PessoaResponseDto {
    @ApiModelProperty(value = "Código da pessoa")
    private Long id;
    private String nome;
    private List<EnderecoResponseDto> enderecos;
}
