package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.clienteDTO.ClienteRequestDTO;
import com.barbearia.EPBD.dto.clienteDTO.ClienteResponseDTO;
import com.barbearia.EPBD.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteResponseDTO toResponseDTO(Cliente cliente);

    @Mapping(target = "senha", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);
}
