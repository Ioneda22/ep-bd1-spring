package com.barbearia.EPBD.dto.barbeiroDTO;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BarbeiroRequestDTO extends PessoaRequestDTO {

    @NotNull(message = "A data de início é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataInicio;
}
