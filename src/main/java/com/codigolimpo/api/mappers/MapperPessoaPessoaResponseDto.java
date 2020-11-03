package com.codigolimpo.api.mappers;

import com.codigolimpo.api.dto.pessoa.PessoaResponseDto;
import com.codigolimpo.domain.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring" , uses = {MapperEnderecoEnderecoResponseDto.class})
public interface MapperPessoaPessoaResponseDto {

    Pessoa toEntity(PessoaResponseDto pessoaResponseDto);

    PessoaResponseDto toDto(Pessoa pessoa);

    Pessoa toEntityUpdate(PessoaResponseDto pessoaResponseDto, @MappingTarget Pessoa pessoa);

}
