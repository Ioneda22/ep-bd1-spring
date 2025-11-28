package com.barbearia.EPBD.mapper;

import com.barbearia.EPBD.dto.pessoaDTO.PessoaRequestDTO;
import com.barbearia.EPBD.dto.pessoaDTO.PessoaResponseDTO;
import com.barbearia.EPBD.model.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaResponseDTO toResponseDTO(Pessoa pessoa);

    @Mapping(target = "senha", ignore = true)
    Pessoa toEntity(PessoaRequestDTO dto);
}
