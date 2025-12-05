package com.barbearia.EPBD.dto.servicoDTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoResumoDTO {
    private Integer id;
    private String nome;
    private BigDecimal preco;
}
