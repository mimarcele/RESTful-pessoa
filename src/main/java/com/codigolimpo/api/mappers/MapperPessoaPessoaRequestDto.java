package com.codigolimpo.api.mappers;

import com.codigolimpo.api.dto.pessoa.PessoaRequestDto;
import com.codigolimpo.domain.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {MapperEnderecoEnderecoRequestDto.class})
public interface MapperPessoaPessoaRequestDto {

    Pessoa toEntity(PessoaRequestDto pessoaRequestDto);

    PessoaRequestDto toDto(Pessoa pessoa);

    Pessoa toEntityUpdate(PessoaRequestDto pessoaRequestDto, @MappingTarget Pessoa pessoa);
}
