package com.codigolimpo.api.dto.pessoa;

import com.codigolimpo.api.dto.EnderecoDto;
import lombok.Data;

import java.util.List;


@Data
public class PessoaRequestDto {
    private String nome;
    private List<EnderecoDto> enderecos;
}
