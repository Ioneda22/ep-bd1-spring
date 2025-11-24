package com.barbearia.EPBD.repository;

import com.barbearia.EPBD.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    Optional<Pessoa> findByEmail(String email);

    Page<Pessoa> findAll(Pageable pageable);
}