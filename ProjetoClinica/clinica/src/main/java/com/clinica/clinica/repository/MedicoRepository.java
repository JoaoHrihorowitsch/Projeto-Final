package com.clinica.clinica.repository;
import com.clinica.clinica.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
    void deleteByCrm (long crm);
    
    Medico findByCrm (long crm);

    @Query("SELECT m FROM Medico m WHERE m.nome LIKE %:nome%")
    List<Medico> findByNome(String nome);
}
