package com.codigolimpo.service.impl;

import com.codigolimpo.models.dto.EnderecoDto;
import com.codigolimpo.models.entities.Endereco;
import com.codigolimpo.exception.EnderecoNotFoundException;
import com.codigolimpo.mappers.MapperEnderecoEnderecoDto;
import com.codigolimpo.repository.EnderecoRepository;
import com.codigolimpo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MapperEnderecoEnderecoDto mapperEnderecoEnderecoDto;

    @Override
    public EnderecoDto criar(EnderecoDto enderecoDto) {
        Endereco endereco = mapperEnderecoEnderecoDto.toEntity(enderecoDto);
        endereco = enderecoRepository.save(endereco);
        EnderecoDto enderecoDto1 = mapperEnderecoEnderecoDto.toDto(endereco);
        return enderecoDto1;
    }

    @Override
    public List<EnderecoDto> listar() {
        List<Endereco> enderecos = enderecoRepository.findAll();

        List<EnderecoDto> enderecoDtos = enderecos
                .stream()
                .map(endereco -> {
                    return mapperEnderecoEnderecoDto.toDto(endereco);
                })
                .collect(Collectors.toList());
        return enderecoDtos;
    }

    @Override
    public EnderecoDto buscar(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);

        Endereco endereco = enderecoOptional
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + id + " não encontrado"));

        EnderecoDto enderecoDto = mapperEnderecoEnderecoDto.toDto(endereco);
        return enderecoDto;
    }

    @Override
    public void deletar(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);

        Endereco endereco = enderecoOptional
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + id + " não encontrado"));
        enderecoRepository.delete(enderecoOptional.get());
    }

    @Override
    public EnderecoDto atualizar(EnderecoDto enderecoDto) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(enderecoDto.getId());

        Endereco endereco = enderecoOptional
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + enderecoDto.getId() + " não encontrado"));

        mapperEnderecoEnderecoDto.toEntityAtualizar(enderecoDto, endereco);
        enderecoRepository.save(endereco);

        EnderecoDto enderecoDto1 = mapperEnderecoEnderecoDto.toDto(endereco);
        return enderecoDto1;
    }
}
