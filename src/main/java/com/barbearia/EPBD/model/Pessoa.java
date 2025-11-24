package com.barbearia.EPBD.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @Column(length = 11)
    private String cpf;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(length = 20)
    private String telefone;

    private String endereco;

    @Column(length = 11, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
}
