package com.barbearia.EPBD.repository;

import com.barbearia.EPBD.model.BarbeiroChefe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbeiroChefeRepository extends JpaRepository<BarbeiroChefe, String> {

    boolean existsByBarbeiroCpf(String cpf);
}
