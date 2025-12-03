package com.barbearia.EPBD.dto.barbeiroChefeDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class BarbeiroChefeRequestDTO {

    @NotBlank(message = "O cpf do barbeiro é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;
}
