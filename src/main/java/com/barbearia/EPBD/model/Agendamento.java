package com.barbearia.EPBD.model;

import com.barbearia.EPBD.model.enums.StatusAgendamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Integer id;

    @NotNull
    @Column(name = "data_hora_agendamento", nullable = false)
    LocalDateTime dataHoraAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    StatusAgendamento status;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    Barbeiro barbeiro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "Contem",
            joinColumns = @JoinColumn(name = "id_agen"),
            inverseJoinColumns = @JoinColumn(name = "id_serv")
    )
    List<Servico> servicos;
}
