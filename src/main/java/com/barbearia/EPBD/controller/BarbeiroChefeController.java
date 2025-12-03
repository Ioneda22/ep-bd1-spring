package com.barbearia.EPBD.controller;

import com.barbearia.EPBD.dto.barbeiroChefeDTO.BarbeiroChefeResponseDTO;
import com.barbearia.EPBD.service.BarbeiroChefeService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("barbearia/v1/barbeiros-chefes")
@RequiredArgsConstructor
public class BarbeiroChefeController {

    private final BarbeiroChefeService barbeiroChefeService;

    @GetMapping
    public ResponseEntity<Page<BarbeiroChefeResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "barbeiro.nomeCompleto") Pageable pageable) {
        return ResponseEntity.ok(barbeiroChefeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarbeiroChefeResponseDTO> findById(
            @PathVariable
            @Min(value = 1, message = "Id deve ser maior que 0")
            Integer id) {
        return ResponseEntity.ok(barbeiroChefeService.findById(id));
    }
}