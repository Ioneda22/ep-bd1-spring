package com.barbearia.EPBD.dto.servicoDTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoResponseDTO {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer duracaoEstimadaMin;
    private String descricao;
}
