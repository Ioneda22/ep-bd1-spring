package com.barbearia.EPBD.dto.barbeiroDTO;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoResumoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BarbeiroResponseDTO extends PessoaResponseDTO {
    private LocalDate dataInicio;

    private List<ServicoResumoDTO> servicos;
}
