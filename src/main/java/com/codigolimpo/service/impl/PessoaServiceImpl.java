package com.codigolimpo.service.impl;

import com.codigolimpo.models.dto.PessoaDto;
import com.codigolimpo.models.entities.Endereco;
import com.codigolimpo.models.entities.Pessoa;
import com.codigolimpo.exception.EnderecoNotFoundException;
import com.codigolimpo.exception.PessoaNotFoundException;
import com.codigolimpo.mappers.MapperPessoaPessoaDto;
import com.codigolimpo.repository.EnderecoRepository;
import com.codigolimpo.repository.PessoaRepository;
import com.codigolimpo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private MapperPessoaPessoaDto mapperPessoaPessoaDto;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public PessoaDto criar(PessoaDto pessoaDto) {
        Pessoa pessoa = mapperPessoaPessoaDto.toEntity(pessoaDto);
        pessoa = pessoaRepository.save(pessoa);
        PessoaDto pessoaDto1 = mapperPessoaPessoaDto.toDto(pessoa);
        return pessoaDto1;
    }

    @Override
    public List<PessoaDto> listar() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

                List<PessoaDto> pessoaDtos = pessoas
                .stream()
                .map(pessoa -> {
                  return mapperPessoaPessoaDto.toDto(pessoa);

                })
                .collect(Collectors.toList());

        return pessoaDtos;
    }

    @Override
    public PessoaDto buscar(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

        Pessoa pessoa = pessoaOptional
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa " + id + " não encontrada"));

       PessoaDto pessoaDto = mapperPessoaPessoaDto.toDto(pessoa);

        return pessoaDto;
    }


    @Override
    public void deletar(Long id) {
    Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
    Pessoa pessoa = pessoaOptional
            .orElseThrow(() -> new PessoaNotFoundException("Pessoa " + id + " não encontrada"));

    pessoaRepository.delete(pessoa);
    }

    @Override
    public PessoaDto atualizar(PessoaDto pessoaDto) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaDto.getId());

        Pessoa pessoa = optionalPessoa
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa " + pessoaDto.getId() + " não encontrada"));

        mapperPessoaPessoaDto.toEntityUpdate(pessoaDto, pessoa);
        pessoaRepository.save(pessoa);

        PessoaDto pessoaDto1 = mapperPessoaPessoaDto.toDto(pessoa);
        return pessoaDto1;
    }

    @Override
    public PessoaDto adicionarEndereco(Long idEndereco, Long idPessoa) {
   Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
    if (pessoa == null){
        throw new PessoaNotFoundException("Pessoa " + idPessoa + " não encontrada");
    }
        Endereco endereco = enderecoRepository.findById(idEndereco).get();
    if(endereco == null){
        throw new EnderecoNotFoundException("Endereço não encontrado");
    }

    pessoa.getEnderecos().add(endereco);

    pessoaRepository.save(pessoa);

    PessoaDto pessoaDto = mapperPessoaPessoaDto.toDto(pessoa);

    return pessoaDto;
    }

    @Override
    public PessoaDto removerEndereco(Long idEndereco, Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();
        if(pessoa == null){
            throw new PessoaNotFoundException("Pessoa " + idPessoa + " não encontrada");
        }
        for ( Endereco endereco: pessoa.getEnderecos()) {
            if(endereco.getId().equals(idEndereco)){
                pessoa.getEnderecos().remove(endereco);
                break;
            }
        }
        pessoaRepository.save(pessoa);

        PessoaDto pessoaDto = mapperPessoaPessoaDto.toDto(pessoa);

        return pessoaDto;
    }
}


