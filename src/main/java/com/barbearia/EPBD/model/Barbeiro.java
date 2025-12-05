package com.barbearia.EPBD.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Barbeiro")
@PrimaryKeyJoinColumn(name = "cpf")
public class Barbeiro extends Pessoa {

    @NotNull
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @ManyToMany
    @JoinTable(
            name = "Oferece",
            joinColumns = @JoinColumn(name = "cpf_barbeiro"),
            inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    List<Servico> servicos;
}
