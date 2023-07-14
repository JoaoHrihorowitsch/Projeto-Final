package com.clinica.clinica.repository;

import com.clinica.clinica.model.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository <Consulta, Integer>  {

    
}
