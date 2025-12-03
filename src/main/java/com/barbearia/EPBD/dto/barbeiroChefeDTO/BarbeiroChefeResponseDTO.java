package com.barbearia.EPBD.dto.barbeiroChefeDTO;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResponseDTO;
import lombok.Data;

@Data
public class BarbeiroChefeResponseDTO {
    private Integer id;
    BarbeiroResponseDTO barbeiroResponseDTO;
}
