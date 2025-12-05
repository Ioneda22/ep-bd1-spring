package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.servicoDTO.ServicoRequestDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.model.Servico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    ServicoResponseDTO toResponseDto(Servico servico);

    Servico toEntity(ServicoRequestDTO dto);
}
