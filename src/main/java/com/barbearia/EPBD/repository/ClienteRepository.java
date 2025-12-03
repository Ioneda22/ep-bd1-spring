package com.barbearia.EPBD.repository;

import com.barbearia.EPBD.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    boolean existsByEmail(String email);
    Page<Cliente> findByNomeCompletoContainingIgnoreCase(String nome, Pageable pageable);
}