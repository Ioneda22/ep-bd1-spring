package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.model.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaResponseDTO toResponseDTO(Pessoa pessoa);
}
