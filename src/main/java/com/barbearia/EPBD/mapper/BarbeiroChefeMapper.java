package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.barbeiroChefeDTO.BarbeiroChefeResponseDTO;
import com.barbearia.EPBD.model.BarbeiroChefe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BarbeiroMapper.class})
public interface BarbeiroChefeMapper {

    @Mapping(source = "barbeiro", target = "barbeiroResponseDTO")
    @Mapping(source = "id", target = "id")
    BarbeiroChefeResponseDTO toResponseDTO(BarbeiroChefe barbeiroChefe);
}
