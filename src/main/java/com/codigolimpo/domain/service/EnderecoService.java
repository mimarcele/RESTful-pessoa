package com.codigolimpo.domain.service;

import com.codigolimpo.api.dto.EnderecoDto;
import com.codigolimpo.domain.entities.Endereco;


import java.util.List;

public interface EnderecoService {

    EnderecoDto criar(EnderecoDto enderecoDto);
    List<EnderecoDto> listar();
    EnderecoDto buscar(Long id);
    void deletar(Long id);
    EnderecoDto atualizar(EnderecoDto enderecoDto);
    Endereco findById(final Long id);
}
