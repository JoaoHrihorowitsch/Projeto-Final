package com.clinica.clinica.repository;

import com.clinica.clinica.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    void deleteByCpf(long cpf);

    Paciente findByCpf (long cpf);

    @Query("SELECT p FROM Paciente p WHERE p.nome LIKE %:nome%")
    List<Paciente> findByNome(String nome);
    
}
