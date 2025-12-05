package com.barbearia.EPBD.dto.servicoDTO;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoUpdateDTO {

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @Positive(message = "A duração deve ser maior que zero")
    private Integer duracaoEstimadaMin;

    private String descricao;
}
