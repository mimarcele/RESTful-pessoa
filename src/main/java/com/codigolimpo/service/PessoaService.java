package com.codigolimpo.service;

import com.codigolimpo.models.dto.PessoaDto;

import java.util.List;

public interface PessoaService {
    PessoaDto criar(PessoaDto pessoaDto);

    List<PessoaDto> listar();

    PessoaDto buscar(Long id);

    void deletar(Long id);

    PessoaDto atualizar(PessoaDto pessoaDto);

    PessoaDto adicionarEndereco(Long idEndereco, Long idPessoa);

    PessoaDto removerEndereco(Long idEndereco, Long idPessoa);
}
