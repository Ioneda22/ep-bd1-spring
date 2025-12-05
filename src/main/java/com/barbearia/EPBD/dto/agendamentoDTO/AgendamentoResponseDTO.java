package com.barbearia.EPBD.dto.agendamentoDTO;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResumoDTO;
import com.barbearia.EPBD.dto.clienteDTO.ClienteResponseDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoResumoDTO;
import com.barbearia.EPBD.model.enums.StatusAgendamento;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoResponseDTO {
    private Integer id;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraFim;
    private StatusAgendamento status;

    // Objetos aninhados (mas resumidos)
    private BarbeiroResumoDTO barbeiro;
    private ClienteResponseDTO cliente;
    private List<ServicoResumoDTO> servicos;

    private Double valorTotal;
}
