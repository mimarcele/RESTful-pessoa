package com.codigolimpo.api.mappers;

import com.codigolimpo.api.dto.EnderecoDto;
import com.codigolimpo.domain.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoDto {

    EnderecoDto toDto(Endereco endereco);

    Endereco toEntity(EnderecoDto enderecoDto);

    void toEntityAtualizar(EnderecoDto enderecoDto, @MappingTarget Endereco endereco);

}
