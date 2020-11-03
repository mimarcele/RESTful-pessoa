package com.codigolimpo.api.mappers;

import com.codigolimpo.api.dto.endereco.EnderecoResponseDto;
import com.codigolimpo.domain.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoResponseDto {

    Endereco toEntity(EnderecoResponseDto enderecoResponseDto);

    EnderecoResponseDto toDto(Endereco endereco);

    Endereco toEntityUpdate(EnderecoResponseDto enderecoResponseDto, @MappingTarget Endereco endereco);
}
