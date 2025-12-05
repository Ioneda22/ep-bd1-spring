package com.barbearia.EPBD.controller;

import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoUpdateDTO;
import com.barbearia.EPBD.service.ServicoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("barbearia/v1/servicos")
@RequiredArgsConstructor
@Validated
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<ServicoResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(servicoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> findById(
            @PathVariable
            @Min(value = 1, message = "Id deve ser maior que 0")
            Integer id) {
        return ResponseEntity.ok(servicoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> updateEntity(
            @RequestBody @Valid ServicoUpdateDTO dto,
            @PathVariable
            @Min(value = 1, message = "Id deve ser maior que 0")
            Integer id) {
        return ResponseEntity.ok(servicoService.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(
            @PathVariable
            @Min(value = 1, message = "Id deve ser maior que 0")
            Integer id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
