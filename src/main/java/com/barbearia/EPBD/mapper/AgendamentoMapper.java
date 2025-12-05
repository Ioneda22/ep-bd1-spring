package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.agendamentoDTO.AgendamentoResponseDTO;
import com.barbearia.EPBD.model.Agendamento;
import com.barbearia.EPBD.model.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BarbeiroMapper.class, ClienteMapper.class, ServicoMapper.class})
public interface AgendamentoMapper {

    @Mapping(target = "valorTotal", source = "servicos", qualifiedByName = "calcularTotal")
    AgendamentoResponseDTO toResponseDTO(Agendamento agendamento);

    @Named("calcularTotal")
    default Double calcularTotal(List<Servico> servicos) {
        if (servicos == null) return 0.0;
        return servicos.stream()
                .mapToDouble(s -> s.getPreco().doubleValue())
                .sum();
    }
}