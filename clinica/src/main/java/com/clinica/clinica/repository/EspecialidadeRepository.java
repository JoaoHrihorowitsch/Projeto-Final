package com.clinica.clinica.repository;
import com.clinica.clinica.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer>{

    @Query("SELECT e FROM Especialidade e WHERE e.especialidade LIKE %:especialidade%")
    List<Especialidade> findByEspecialidade(@Param("especialidade") String espec);
    
}
