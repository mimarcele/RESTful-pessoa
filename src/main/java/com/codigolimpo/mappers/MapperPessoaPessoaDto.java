package com.codigolimpo.mappers;

import com.codigolimpo.models.dto.PessoaDto;
import com.codigolimpo.models.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = { MapperEnderecoEnderecoDto.class })
public interface MapperPessoaPessoaDto {

    PessoaDto toDto(Pessoa pessoa);

    Pessoa toEntity(PessoaDto pessoaDto);

     void toEntityUpdate(PessoaDto pessoaDto, @MappingTarget Pessoa pessoa);
}
