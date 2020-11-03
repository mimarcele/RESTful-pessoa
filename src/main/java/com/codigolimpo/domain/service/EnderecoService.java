package com.codigolimpo.domain.service;

import com.codigolimpo.api.dto.endereco.EnderecoRequestDto;
import com.codigolimpo.api.dto.endereco.EnderecoResponseDto;
import com.codigolimpo.domain.entities.Endereco;

import java.util.List;

public interface EnderecoService {

    EnderecoResponseDto criar(EnderecoRequestDto enderecoRequestDto);
    List<EnderecoResponseDto> listar();
    EnderecoResponseDto buscar(Long id);
    void deletar(Long id);
    EnderecoResponseDto atualizar(EnderecoRequestDto enderecoRequestDto);
    Endereco findById(final Long id);
}
