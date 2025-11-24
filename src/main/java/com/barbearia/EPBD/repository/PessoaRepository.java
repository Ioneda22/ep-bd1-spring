package com.barbearia.EPBD.repository;

import com.barbearia.EPBD.model.Pessoa;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

@NullMarked
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    Optional<Pessoa> findByEmail(String email);

    @NullMarked
    Page<Pessoa> findAll(Pageable pageable);

    boolean existsByEmail(String email);
}