package com.clinica.clinica.repository;

import com.clinica.clinica.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    void deleteByCpf(long cpf);

    Paciente findByCpf (long cpf);
}
