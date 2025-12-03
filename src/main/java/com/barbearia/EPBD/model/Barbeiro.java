package com.barbearia.EPBD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

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
}
