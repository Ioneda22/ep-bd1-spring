package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.mapper.ServicoMapper;
import com.barbearia.EPBD.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;

    @Transactional(readOnly = true)
    public Page<ServicoResponseDTO> findAll(Pageable pageable) {
        return servicoRepository.findAll(pageable)
                .map(servicoMapper::toResponseDto);
    }

    @Transactional(readOnly = true)
    public ServicoResponseDTO findById(Integer id) {
        return servicoRepository.findById(id)
                .map(servicoMapper::toResponseDto)
                .orElseThrow(() -> new ResourceNotFoundException("Servico com id " + id + " não encontrado."));
    }
}
