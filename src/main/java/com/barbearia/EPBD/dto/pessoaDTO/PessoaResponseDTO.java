package com.barbearia.EPBD.dto.pessoaDTO;
import com.barbearia.EPBD.model.Pessoa;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class PessoaResponseDTO {
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;

    public PessoaResponseDTO(Pessoa pessoa) {
        this.cpf = pessoa.getCpf();
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.email = pessoa.getEmail();
        this.telefone = pessoa.getTelefone();
    }
}
