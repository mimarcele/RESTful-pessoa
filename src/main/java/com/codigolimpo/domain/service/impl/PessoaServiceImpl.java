package com.codigolimpo.domain.service.impl;

import com.codigolimpo.api.dto.pessoa.PessoaRequestDto;
import com.codigolimpo.api.dto.pessoa.PessoaResponseDto;
import com.codigolimpo.api.exception.PessoaCreateException;
import com.codigolimpo.api.exception.PessoaNotFoundException;
import com.codigolimpo.api.exception.PessoaUpdateException;
import com.codigolimpo.api.mappers.MapperPessoaPessoaRequestDto;
import com.codigolimpo.api.mappers.MapperPessoaPessoaResponseDto;
import com.codigolimpo.domain.entities.Endereco;
import com.codigolimpo.domain.entities.Pessoa;
import com.codigolimpo.domain.repository.PessoaRepository;
import com.codigolimpo.domain.service.EnderecoService;
import com.codigolimpo.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final MapperPessoaPessoaResponseDto mapperPessoaPessoaResponseDto;
    private final MapperPessoaPessoaRequestDto mapperPessoaPessoaRequestDto;
    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;

    @Override
    public PessoaResponseDto criar(final PessoaRequestDto pessoaRequestDto) {
                return of(pessoaRequestDto)
                .map(mapperPessoaPessoaRequestDto::toEntity)
                .map(p -> criar(pessoaRequestDto))
                .orElseThrow(() -> new PessoaCreateException("Falha ao criar a pessoa: " + pessoaRequestDto));
    }

    @Override
    public List<PessoaResponseDto> listar() {
                return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> mapperPessoaPessoaResponseDto.toDto(pessoa))
                .collect(Collectors.toList());
    }

    @Override
    public PessoaResponseDto buscar(final Long id) {
     return mapperPessoaPessoaResponseDto.toDto(pessoaRepository.getOne(id));
    }

    @Override
    public void deletar(final Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (Exception e) {
            throw new PessoaNotFoundException("Pessoa não encontrada");
        }
    }

    @Override
    public PessoaResponseDto atualizar(final PessoaRequestDto pessoaRequestDto) {
                return of(getPessoa(pessoaRequestDto.getId()))
                .map(p -> { mapperPessoaPessoaRequestDto.toEntityUpdate(pessoaRequestDto, p);
                    return p;
                })
                .map(this::criarPessoaEToDto)
                .orElseThrow(() -> new PessoaUpdateException("Falha ao atualizar a pessoa com id: " + pessoaRequestDto.getId()));
    }

    @Override
    public PessoaResponseDto adicionarEndereco(final Long idEndereco, final Long idPessoa) {
//        return Optional.of()
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
    public PessoaResponseDto removerEndereco(final Long idEndereco,final Long idPessoa) {
                return of(getPessoa(idPessoa))
                .map(p -> {
                    final Endereco endereco = enderecoService.findById(idEndereco);
                    p.removerEndereco(endereco);
                    return p;
                })

                .map(p -> criarPessoaEToDto(p))
                .orElseThrow(() -> new PessoaUpdateException("Falha ao adicionar o endereço a pessoa:" + idPessoa));
    }

        private PessoaResponseDto criarPessoaEToDto(final Pessoa pessoa) {
        return Optional.of(pessoaRepository.save((pessoa)))
                .map(mapperPessoaPessoaResponseDto::toDto)
                .orElseThrow(() -> new PessoaUpdateException("Falha no processo de salvar e transformar a pessoa em DTO. Pessoa: "));
    }

    private Pessoa getPessoa(final Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada"));
    }

}


