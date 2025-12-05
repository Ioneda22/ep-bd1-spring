package com.barbearia.EPBD.dto.servicoDTO;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResumoDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ServicoResponseDTO {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer duracaoEstimadaMin;
    private String descricao;
    private List<BarbeiroResumoDTO> barbeiros;
}
