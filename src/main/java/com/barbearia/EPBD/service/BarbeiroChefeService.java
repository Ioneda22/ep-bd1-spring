package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.barbeiroChefeDTO.BarbeiroChefeResponseDTO;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.mapper.BarbeiroChefeMapper;
import com.barbearia.EPBD.repository.BarbeiroChefeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BarbeiroChefeService {

    private final BarbeiroChefeRepository barbeiroChefeRepository;
    private final BarbeiroChefeMapper barbeiroChefeMapper;

    @Transactional(readOnly = true)
    public Page<BarbeiroChefeResponseDTO> findAll(Pageable pageable) {
        return barbeiroChefeRepository.findAll(pageable)
                .map(barbeiroChefeMapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public BarbeiroChefeResponseDTO findById(String id) {
        return barbeiroChefeRepository.findById(id)
                .map(barbeiroChefeMapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Barbeiro Chefe não encontrado com Id: " + id));
    }
}
