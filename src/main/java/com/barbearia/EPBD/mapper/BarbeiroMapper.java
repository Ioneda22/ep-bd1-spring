package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroRequestDTO;
import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResponseDTO;
import com.barbearia.EPBD.model.Barbeiro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BarbeiroMapper {
    BarbeiroResponseDTO toResponseDTO(Barbeiro barbeiro);

    @Mapping(target="senha", ignore = true)
    Barbeiro toEntity(BarbeiroRequestDTO dto);
}
