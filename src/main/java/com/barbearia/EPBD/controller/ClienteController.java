package com.barbearia.EPBD.controller;

import com.barbearia.EPBD.dto.clienteDTO.ClienteRequestDTO;
import com.barbearia.EPBD.dto.clienteDTO.ClienteResponseDTO;
import com.barbearia.EPBD.service.ClienteService;
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
@RequestMapping("barbearia/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "nomeCompleto") Pageable pageable) {
        return ResponseEntity.ok(clienteService.findAll(pageable));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponseDTO> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clienteService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(
            @RequestBody @Valid ClienteRequestDTO clienteRequestDTO,
            UriComponentsBuilder uriComponentsBuilder) {
        ClienteResponseDTO clienteResponseDTO = clienteService.create(clienteRequestDTO);

        URI uri = uriComponentsBuilder
                .path("/barbearia/v1/clientes/{cpf}")
                .buildAndExpand(clienteResponseDTO.getCpf())
                .toUri();

        return ResponseEntity.created(uri).body(clienteResponseDTO);
    }
}
