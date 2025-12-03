package com.barbearia.EPBD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Cliente")
@PrimaryKeyJoinColumn(name = "cpf")
public class Cliente extends Pessoa {

}
