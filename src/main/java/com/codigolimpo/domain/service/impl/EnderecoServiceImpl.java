package com.codigolimpo.domain.service.impl;

import com.codigolimpo.api.dto.EnderecoDto;
import com.codigolimpo.domain.entities.Endereco;
import com.codigolimpo.api.exception.EnderecoNotFoundException;
import com.codigolimpo.api.mappers.MapperEnderecoEnderecoDto;
import com.codigolimpo.domain.repository.EnderecoRepository;
import com.codigolimpo.domain.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    private final MapperEnderecoEnderecoDto mapperEnderecoEnderecoDto;

    @Override
    public EnderecoDto criar(final EnderecoDto enderecoDto) {
        return of(enderecoDto)
                .map(mapperEnderecoEnderecoDto::toEntity)
                .map(en -> criarEnderecoEToDto(en))
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado"));
//        Endereco endereco = mapperEnderecoEnderecoDto.toEntity(enderecoDto);
//        endereco = enderecoRepository.save(endereco);
//        EnderecoDto enderecoDto1 = mapperEnderecoEnderecoDto.toDto(endereco);
//        return enderecoDto1;
    }

    @Override
    public List<EnderecoDto> listar() {
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> mapperEnderecoEnderecoDto.toDto(endereco))
                .collect(Collectors.toList());

//        List<Endereco> enderecos = enderecoRepository.findAll();
//
//        List<EnderecoDto> enderecoDtos = enderecos
//                .stream()
//                .map(endereco -> {
//                    return mapperEnderecoEnderecoDto.toDto(endereco);
//                })
//                .collect(Collectors.toList());
//        return enderecoDtos;
    }

    @Override
    public EnderecoDto buscar(final Long id) {
        return mapperEnderecoEnderecoDto.toDto(enderecoRepository.getOne(id));

//        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
//
//        Endereco endereco = enderecoOptional
//                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + id + " não encontrado"));
//
//        EnderecoDto enderecoDto = mapperEnderecoEnderecoDto.toDto(endereco);
//        return enderecoDto;
    }

    @Override
    public void deletar(final Long id) {
        try{
            enderecoRepository.deleteById(id);
        } catch (Exception e){

        }
//        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
//
//        Endereco endereco = enderecoOptional
//                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + id + " não encontrado"));
//        enderecoRepository.delete(enderecoOptional.get());
    }

    @Override
    public EnderecoDto atualizar(final EnderecoDto enderecoDto) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(enderecoDto.getId());

        Endereco endereco = enderecoOptional
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + enderecoDto.getId() + " não encontrado"));

        mapperEnderecoEnderecoDto.toEntityAtualizar(enderecoDto, endereco);
        enderecoRepository.save(endereco);

        EnderecoDto enderecoDto1 = mapperEnderecoEnderecoDto.toDto(endereco);
        return enderecoDto1;
    }

    @Override
    public Endereco findById(final Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + id + " não encontrado"));
    }

    private EnderecoDto criarEnderecoEToDto(final Endereco endereco){
        return of(enderecoRepository.save(endereco))
                .map(mapperEnderecoEnderecoDto::toDto)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado"));
    }
}

