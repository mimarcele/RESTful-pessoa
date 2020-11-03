package com.codigolimpo.api.mappers;

import com.codigolimpo.api.dto.endereco.EnderecoRequestDto;
import com.codigolimpo.domain.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoRequestDto {

    Endereco toEntity(EnderecoRequestDto enderecoRequestDto);

    EnderecoRequestDto toDto(Endereco endereco);

    Endereco toEntityUpdate(EnderecoRequestDto enderecoRequestDto, @MappingTarget Endereco endereco);
}
