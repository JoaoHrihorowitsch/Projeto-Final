package com.clinica.clinica.repository;
import com.clinica.clinica.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{
    void deleteByCrm (long crm);
    
    Medico findByCrm (long crm);
}
