package com.barbearia.EPBD.dto.agendamentoDTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AgendamentoRequestDTO {
    @NotNull(message = "A data e hora são obrigatórias")
    @Future(message = "A data do agendamento deve ser no futuro")
    private LocalDateTime dataHoraAgendamento;

    @NotNull(message = "CPF do cliente é obrigatório")
    @CPF(message = "CPF do cliente inválido")
    private String cpfCliente;

    @NotNull(message = "CPF do barbeiro é obrigatório")
    @CPF(message = "CPF do barbeiro inválido")
    private String cpfBarbeiro;

    @NotEmpty(message = "Selecione pelo menos um serviço")
    private List<Integer> idsServicos;
}
