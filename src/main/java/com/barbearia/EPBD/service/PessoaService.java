package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.model.Pessoa;
import com.barbearia.EPBD.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @NullMarked
    public Page<PessoaResponseDTO> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable)
                .map(PessoaResponseDTO::new);
    }

    public PessoaResponseDTO findByCpf(String cpf) {
        return pessoaRepository.findById(cpf).
                map(PessoaResponseDTO::new).
                orElse(null);
    }

    public PessoaResponseDTO findByEmail(String email) {
        return pessoaRepository.findByEmail(email).
                map(PessoaResponseDTO::new).
                orElse(null);
    }
}