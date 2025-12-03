package com.barbearia.EPBD.controller;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroRequestDTO;
import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResponseDTO;
import com.barbearia.EPBD.service.BarbeiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("barbearia/v1/barbeiros")
@RequiredArgsConstructor
public class BarbeiroController {

    private final BarbeiroService barbeiroService;

    @GetMapping
    public ResponseEntity<Page<BarbeiroResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "nomeCompleto") Pageable pageable) {
        return ResponseEntity.ok(barbeiroService.findAll(pageable));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<BarbeiroResponseDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(barbeiroService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<BarbeiroResponseDTO> create(
            @RequestBody @Valid BarbeiroRequestDTO barbeiroRequestDTO,
            UriComponentsBuilder uriComponentsBuilder) {
        BarbeiroResponseDTO barbeiroResponseDTO = barbeiroService.create(barbeiroRequestDTO);

        URI uri = uriComponentsBuilder
                .path("/barbearia/v1/barbeiros/{cpf}")
                .buildAndExpand(barbeiroResponseDTO.getCpf())
                .toUri();

        return ResponseEntity.created(uri).body(barbeiroResponseDTO);
    }
}
