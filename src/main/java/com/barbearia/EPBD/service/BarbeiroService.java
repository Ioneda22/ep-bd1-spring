package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroRequestDTO;
import com.barbearia.EPBD.dto.barbeiroDTO.BarbeiroResponseDTO;
import com.barbearia.EPBD.exception.BusinessRuleException;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.mapper.BarbeiroMapper;
import com.barbearia.EPBD.model.Barbeiro;
import com.barbearia.EPBD.repository.BarbeiroRepository;
import com.barbearia.EPBD.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;
    private final PessoaRepository pessoaRepository;
    private final BarbeiroMapper barbeiroMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Page<BarbeiroResponseDTO> findAll(Pageable pageable) {
        return barbeiroRepository.findAll(pageable)
                .map(barbeiroMapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public BarbeiroResponseDTO findByCpf(String cpf) {
        return barbeiroRepository.findById(cpf)
                .map(barbeiroMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Barbeiro não encontrado com CPF: " + cpf));
    }

    @Transactional
    public BarbeiroResponseDTO create(BarbeiroRequestDTO barbeiroRequestDTO) {

        if(pessoaRepository.existsById(barbeiroRequestDTO.getCpf())) {
            throw new BusinessRuleException("Já existe uma pessoa cadastrada com este CPF.");
        }

        if (pessoaRepository.existsByEmail(barbeiroRequestDTO.getEmail())) {
            throw new BusinessRuleException("Já existe uma pessoa cadastrada com este E-mail.");
        }

        Barbeiro barbeiro = barbeiroMapper.toEntity(barbeiroRequestDTO);

        barbeiro.setSenha(passwordEncoder.encode(barbeiroRequestDTO.getSenha()));

        barbeiroRepository.save(barbeiro);

        return  barbeiroMapper.toResponseDTO(barbeiro);
    }
}
