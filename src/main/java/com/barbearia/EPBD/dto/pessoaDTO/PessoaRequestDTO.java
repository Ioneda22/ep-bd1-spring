package com.barbearia.EPBD.dto.pessoaDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;
import lombok.Data;
import java.time.LocalDate;

@Data
public class PessoaRequestDTO {

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nomeCompleto;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data deve ser no passado")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Size(max = 20, message = "Telefone muito longo")
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    private String endereco;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;
}