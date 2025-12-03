package com.barbearia.EPBD.dto.barbeiroDTO;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class BarbeiroResponseDTO extends PessoaResponseDTO {
    private LocalDate dataInicio;
}
