package com.clinica.clinica.repository;

import com.clinica.clinica.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer> {

    @Query("SELECT c FROM Convenio c WHERE c.plano LIKE %:plano%")
    List<Convenio> findByPlano(String plano);
    
}
