package com.codigolimpo.domain.service.impl;

import com.codigolimpo.api.dto.endereco.EnderecoRequestDto;
import com.codigolimpo.api.dto.endereco.EnderecoResponseDto;
import com.codigolimpo.api.exception.EnderecoNotFoundException;
import com.codigolimpo.api.mappers.MapperEnderecoEnderecoRequestDto;
import com.codigolimpo.api.mappers.MapperEnderecoEnderecoResponseDto;
import com.codigolimpo.domain.entities.Endereco;
import com.codigolimpo.domain.repository.EnderecoRepository;
import com.codigolimpo.domain.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final MapperEnderecoEnderecoRequestDto mapperEnderecoEnderecoRequestDto;
    private final MapperEnderecoEnderecoResponseDto mapperEnderecoEnderecoResponseDto;


    @Override
    public EnderecoResponseDto criar(EnderecoRequestDto enderecoRequestDto) {
        return of(enderecoRequestDto)
                .map(mapperEnderecoEnderecoRequestDto::toEntity)
                .map(endereco -> criarEnderecoEToDto(mapperEnderecoEnderecoRequestDto.toEntity(enderecoRequestDto)))
                .orElseThrow(() -> new EnderecoNotFoundException("Falha ao criar endereço"));
//
    }

    @Override
    public List<EnderecoResponseDto> listar() {
                return enderecoRepository.findAll()
                        .stream()
                        .map(endereco -> mapperEnderecoEnderecoResponseDto.toDto(endereco))
                        .collect(Collectors.toList());
    }

    @Override
    public EnderecoResponseDto buscar(Long id) {
        return mapperEnderecoEnderecoResponseDto.toDto(enderecoRepository.getOne(id));
    }

    @Override
    public void deletar(Long id) {
        try{
            enderecoRepository.deleteById(id);
        } catch (Exception e){
            throw new EnderecoNotFoundException("Endereço não encontrado");
        }
    }


    @Override
    public EnderecoResponseDto atualizar(EnderecoRequestDto enderecoRequestDto) {
               Optional<Endereco> enderecoOptional = enderecoRepository.findById(enderecoRequestDto.getId());

        Endereco endereco = enderecoOptional
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + enderecoRequestDto.getId() + " não encontrado"));

        mapperEnderecoEnderecoRequestDto.toEntityUpdate(enderecoRequestDto, endereco);
        enderecoRepository.save(endereco);

        mapperEnderecoEnderecoRequestDto.toDto(endereco);
        EnderecoResponseDto enderecoResponseDto = new EnderecoResponseDto(); //verificar se está certo
     return enderecoResponseDto;
    }


    @Override
    public Endereco findById(Long id) {
                return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço " + id + " não encontrado"));
    }

    private EnderecoResponseDto criarEnderecoEToDto(final Endereco endereco){
        return of(enderecoRepository.save(endereco))
                .map(mapperEnderecoEnderecoResponseDto::toDto)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado"));

    }

}

