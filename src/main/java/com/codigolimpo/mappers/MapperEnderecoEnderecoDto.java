package com.codigolimpo.mappers;

import com.codigolimpo.models.dto.EnderecoDto;
import com.codigolimpo.models.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoDto {

    EnderecoDto toDto(Endereco endereco);

    Endereco toEntity(EnderecoDto enderecoDto);

    void toEntityAtualizar(EnderecoDto enderecoDto, @MappingTarget Endereco endereco);

}
