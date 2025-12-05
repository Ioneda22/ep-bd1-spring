package com.barbearia.EPBD.dto.servicoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoRequestDTO {

    @NotBlank(message = "Nome do serviço é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotNull(message = "O preço do serviço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "A duraçao estimada é obrigatória")
    @Positive(message = "A duração deve ser maior que zero")
    private Integer duracaoEstimadaMin;

    private String descricao;
}
