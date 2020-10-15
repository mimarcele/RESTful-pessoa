package com.codigolimpo.service;

import com.codigolimpo.models.dto.EnderecoDto;


import java.util.List;

public interface EnderecoService {

    EnderecoDto criar(EnderecoDto enderecoDto);
    List<EnderecoDto> listar();
    EnderecoDto buscar(Long id);
    void deletar(Long id);
    EnderecoDto atualizar(EnderecoDto enderecoDto);

}
