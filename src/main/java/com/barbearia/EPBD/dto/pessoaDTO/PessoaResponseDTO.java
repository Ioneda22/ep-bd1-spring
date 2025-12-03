package com.barbearia.EPBD.dto.pessoaDTO;
import lombok.Data;

@Data
public class PessoaResponseDTO {
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;
}
