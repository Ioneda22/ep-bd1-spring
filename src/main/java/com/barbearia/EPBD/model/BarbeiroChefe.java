package com.barbearia.EPBD.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Barbeiro_Chefe")public class BarbeiroChefe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barbeiro_chefe")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cpf_barbeiro", referencedColumnName = "cpf", nullable = false, unique = true)
    private Barbeiro barbeiro;
}
