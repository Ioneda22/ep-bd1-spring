package com.barbearia.EPBD.dto.pessoaDTO;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PessoaRequestDTO {
    private String cpf;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    private String email;
    private String senha;
}
