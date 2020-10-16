package com.codigolimpo.domain.service.impl;

import com.codigolimpo.api.dto.PessoaDto;
import com.codigolimpo.api.exception.PessoaCreateException;
import com.codigolimpo.api.exception.PessoaUpdateException;
import com.codigolimpo.domain.entities.Endereco;
import com.codigolimpo.domain.entities.Pessoa;
import com.codigolimpo.api.exception.PessoaNotFoundException;
import com.codigolimpo.api.mappers.MapperPessoaPessoaDto;
import com.codigolimpo.domain.repository.PessoaRepository;
import com.codigolimpo.domain.service.EnderecoService;
import com.codigolimpo.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final MapperPessoaPessoaDto mapperPessoaPessoaDto;
    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;

    @Override
    public PessoaDto criar(final PessoaDto pessoaDto) {
        return of(pessoaDto)
                .map(mapperPessoaPessoaDto::toEntity)
                .map(p -> criarPessoaEToDto(p))
                .orElseThrow(() -> new PessoaCreateException("Falha ao criar a pessoa: " + pessoaDto));
    }

    @Override
    public List<PessoaDto> listar() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> mapperPessoaPessoaDto.toDto(pessoa))
                .collect(Collectors.toList());
    }

    @Override
    public PessoaDto buscar(final Long id) {
        return mapperPessoaPessoaDto.toDto(getPessoa(id));
    }

    @Override
    public void deletar(Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (Exception e) {
        }
    }

    @Override
    public PessoaDto atualizar(final PessoaDto pessoaDto) {
        return of(getPessoa(pessoaDto.getId()))
                .map(p -> mapperPessoaPessoaDto.toEntityUpdate(pessoaDto, p))
                .map(p -> criarPessoaEToDto(p))
                .orElseThrow(() -> new PessoaUpdateException("Falha ao atualizar a pessoa com id: " + pessoaDto.getId()));
    }

    @Override
    public PessoaDto adicionarEndereco(final Long idEndereco, final Long idPessoa) {
        return of(getPessoa(idPessoa))
                .map(p -> {
                    final Endereco endereco = enderecoService.findById(idEndereco);
                    p.adicionarEndereco(endereco);
                    return p;
                })
                .map(p -> criarPessoaEToDto(p))
                .orElseThrow(() -> new PessoaUpdateException("Falha ao adicionar o endereço a pessoa:" + idPessoa));
    }

    @Override
    public PessoaDto removerEndereco(final Long idEndereco, final Long idPessoa) {
        return of(getPessoa(idPessoa))
                .map(p -> {
                    final Endereco endereco = enderecoService.findById(idEndereco);
                    p.removerEndereco(endereco);
                    return p;
                })
                .map(p -> criarPessoaEToDto(p))
                .orElseThrow(() -> new PessoaUpdateException("Falha ao adicionar o endereço a pessoa:" + idPessoa));
    }

    private Pessoa getPessoa(final Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa " + id + " não encontrada"));
    }

    private PessoaDto criarPessoaEToDto(final Pessoa pessoa) {
        return of(pessoaRepository.save(pessoa))
                .map(mapperPessoaPessoaDto::toDto)
                .orElseThrow(() -> new PessoaUpdateException("Falha no processo de salvar e transformar a pessoa em DTO. Pessoa: " + pessoa));
    }
}


