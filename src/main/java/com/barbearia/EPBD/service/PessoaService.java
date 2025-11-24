package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public Page<PessoaResponseDTO> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable)
                .map(PessoaResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO findByCpf(String cpf) {
        return pessoaRepository.findById(cpf)
                .map(PessoaResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada com CPF: " + cpf));
    }

    @Transactional(readOnly = true)
    public PessoaResponseDTO findByEmail(String email) {
        return pessoaRepository.findByEmail(email)
                .map(PessoaResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Email não encontrado: " + email));
    }
}