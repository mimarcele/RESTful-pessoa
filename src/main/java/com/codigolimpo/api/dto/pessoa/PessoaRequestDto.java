package com.codigolimpo.api.dto.pessoa;

import com.codigolimpo.api.dto.endereco.EnderecoResponseDto;
import lombok.Data;

import java.util.List;


@Data
public class PessoaRequestDto {
    private Long id;
    private String nome;
    private List<EnderecoResponseDto> enderecos;
}
