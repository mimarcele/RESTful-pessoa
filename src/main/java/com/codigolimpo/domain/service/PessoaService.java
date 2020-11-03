package com.codigolimpo.domain.service;

import com.codigolimpo.api.dto.pessoa.PessoaRequestDto;
import com.codigolimpo.api.dto.pessoa.PessoaResponseDto;

import java.util.List;

public interface PessoaService {
    PessoaResponseDto criar(PessoaRequestDto pessoaRequestDto);

    List<PessoaResponseDto> listar();

    PessoaResponseDto buscar(Long id);

    void deletar(Long id);

    PessoaResponseDto atualizar(PessoaRequestDto pessoaRequestDto);

    PessoaResponseDto adicionarEndereco(Long idEndereco, Long idPessoa);

    PessoaResponseDto removerEndereco(Long idEndereco, Long idPessoa);
}
