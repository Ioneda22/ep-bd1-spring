package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.clienteDTO.ClienteRequestDTO;
import com.barbearia.EPBD.dto.clienteDTO.ClienteResponseDTO;
import com.barbearia.EPBD.exception.BusinessRuleException;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.mapper.ClienteMapper;
import com.barbearia.EPBD.model.Cliente;
import com.barbearia.EPBD.repository.ClienteRepository;
import com.barbearia.EPBD.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PessoaRepository pessoaRepository;
    private final ClienteMapper clienteMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Page<ClienteResponseDTO> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(clienteMapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO findByCpf(String cpf) {
        return clienteRepository.findById(cpf)
                .map(clienteMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com CPF: " + cpf));
    }

    @Transactional
    public ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
        if (pessoaRepository.existsById(clienteRequestDTO.getCpf())) {
            throw new BusinessRuleException("Já existe uma pessoa cadastrada com este CPF.");
        }

        if (pessoaRepository.existsByEmail(clienteRequestDTO.getEmail())) {
            throw new BusinessRuleException("Já existe uma pessoa cadastrada com este E-mail.");
        }

        Cliente cliente = clienteMapper.toEntity(clienteRequestDTO);

        cliente.setSenha(passwordEncoder.encode(clienteRequestDTO.getSenha()));

        clienteRepository.save(cliente);

        return clienteMapper.toResponseDTO(cliente);
    }
}
