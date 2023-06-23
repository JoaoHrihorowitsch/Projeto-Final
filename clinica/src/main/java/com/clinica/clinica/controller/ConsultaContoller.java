package com.clinica.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultaContoller {

   @GetMapping("/consulta")
     public String listar() {

        return "consulta/home";
     }

    @GetMapping("/novaConsulta")
     public String create() {

        return "consulta/create";
     }
    
}
