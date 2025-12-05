package com.barbearia.EPBD.service;

import com.barbearia.EPBD.dto.servicoDTO.ServicoRequestDTO;
import com.barbearia.EPBD.dto.servicoDTO.ServicoResponseDTO;
import com.barbearia.EPBD.exception.BusinessRuleException;
import com.barbearia.EPBD.exception.ResourceNotFoundException;
import com.barbearia.EPBD.mapper.ServicoMapper;
import com.barbearia.EPBD.model.Barbeiro;
import com.barbearia.EPBD.model.Servico;
import com.barbearia.EPBD.repository.BarbeiroRepository;
import com.barbearia.EPBD.repository.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final BarbeiroRepository barbeiroRepository;
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

    @Transactional
    public ServicoResponseDTO create(ServicoRequestDTO servicoRequestDTO) {
        Servico servico = servicoMapper.toEntity(servicoRequestDTO);
        servicoRepository.save(servico);

        return servicoMapper.toResponseDto(servico);
    }

    @Transactional
    public ServicoResponseDTO update(ServicoRequestDTO servicoRequestDTO, Integer id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servico com id " + id + " não encontrado."));

        servico.setNome(servicoRequestDTO.getNome());
        servico.setDescricao(servicoRequestDTO.getDescricao());
        servico.setPreco(servicoRequestDTO.getPreco());
        servico.setDuracaoEstimadaMin(servicoRequestDTO.getDuracaoEstimadaMin());

        servicoRepository.save(servico);

        return servicoMapper.toResponseDto(servico);
    }

    @Transactional
    public void delete(Integer id) {
        if (!servicoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Servico com id " + id + " não encontrado.");
        }

        servicoRepository.deleteById(id);
    }
}
