package com.barbearia.EPBD.controller;

import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("barbearia/v1/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<ServicoResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(servicoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> findById(Integer id) {
        return ResponseEntity.ok(servicoService.findById(id));
    }
}
