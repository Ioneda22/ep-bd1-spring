package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResumoDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoRequestDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.model.Servico;
import com.barbearia.EPBD.model.Barbeiro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    ServicoResponseDTO toResponseDto(Servico servico);

    Servico toEntity(ServicoRequestDTO dto);

    @Mapping(source = "nomeCompleto", target = "nome")
    BarbeiroResumoDTO toBarbeiroResumoDto(Barbeiro barbeiro);
}
