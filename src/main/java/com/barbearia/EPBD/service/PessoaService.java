package com.barbearia.EPBD.service;

import com.barbearia.EPBD.config.SecurityConfig;
import com.barbearia.EPBD.dto.pessoaDTO.PessoaRequestDTO;
import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.model.Pessoa;
import com.barbearia.EPBD.repository.PessoaRepository;
import com.barbearia.EPBD.config.SecurityConfig.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PasswordEncoder passwordEncoder;

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

    @Transactional
    public PessoaResponseDTO create(PessoaRequestDTO pessoaRequestDTO) {
        if (pessoaRepository.existsById(pessoaRequestDTO.getCpf())) {
            throw new IllegalArgumentException("Já existe uma pessoa cadastrada com este CPF.");
        }

        if (pessoaRepository.existsByEmail(pessoaRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Já existe uma pessoa cadastrada com este E-mail.");
        }

        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaRequestDTO, pessoa);
        pessoa.setSenha(passwordEncoder.encode(pessoaRequestDTO.getSenha()));
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }
}