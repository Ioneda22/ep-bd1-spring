package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResumoDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoRequestDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoUpdateDTO;
import com.barbearia.EPBD.model.Servico;
import com.barbearia.EPBD.model.Barbeiro;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    ServicoResponseDTO toResponseDto(Servico servico);

    Servico toEntity(ServicoRequestDTO dto);

    @Mapping(source = "nomeCompleto", target = "nome")
    BarbeiroResumoDTO toBarbeiroResumoDto(Barbeiro barbeiro);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ServicoUpdateDTO dto, @MappingTarget Servico servico);
}
