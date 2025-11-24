package com.barbearia.EPBD.controller;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaRequestDTO;
import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.service.PessoaService;
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
@RequestMapping("barbearia/v1/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Page<PessoaResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "nomeCompleto") Pageable pageable) {
        return ResponseEntity.ok(pessoaService.findAll(pageable));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaResponseDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(pessoaService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> create(
            @RequestBody @Valid PessoaRequestDTO pessoaRequestDTO,
            UriComponentsBuilder uriComponentsBuilder) {

        PessoaResponseDTO pessoaResponseDTO = pessoaService.create(pessoaRequestDTO);

        URI uri = uriComponentsBuilder.path("/barbearia/v1/pessoas/{cpf}")
                .buildAndExpand(pessoaResponseDTO.getCpf())
                .toUri();

        return ResponseEntity.created(uri).body(pessoaResponseDTO);
    }
}