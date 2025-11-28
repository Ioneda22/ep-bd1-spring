package com.barbearia.EPBD.dto.pessoaDTO;
import com.barbearia.EPBD.model.Pessoa;
import lombok.Data;
import lombok.Getter;

@Data
public class PessoaResponseDTO {
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;
}
