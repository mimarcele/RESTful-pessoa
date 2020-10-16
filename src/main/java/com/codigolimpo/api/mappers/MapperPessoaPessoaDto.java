package com.codigolimpo.api.mappers;

import com.codigolimpo.api.dto.PessoaDto;
import com.codigolimpo.domain.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { MapperEnderecoEnderecoDto.class })
public interface MapperPessoaPessoaDto {

    PessoaDto toDto(Pessoa pessoa);

    Pessoa toEntity(PessoaDto pessoaDto);

    @Mapping(source = "id", target = "id", ignore = true)
    Pessoa toEntityUpdate(PessoaDto pessoaDto, @MappingTarget Pessoa pessoa);
}
