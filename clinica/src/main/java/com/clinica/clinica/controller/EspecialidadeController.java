package com.clinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.clinica.model.Especialidade;
import com.clinica.clinica.repository.EspecialidadeRepository;


@Controller
public class EspecialidadeController {

   @Autowired
   private EspecialidadeRepository eR;

   @GetMapping("/especialidade")
     public String listar(Model model) {
      List<Especialidade> espec = eR.findAll();
        model.addAttribute("especialidades", espec);

        return "especialidade/home";
     }

    @GetMapping("/novaEspecialidade")
     public String create(Model model) {
      model.addAttribute("especialidade", new Especialidade());
        return "especialidade/create";
     }

     @PostMapping("/novaEspecialidade")
     public String save(@RequestParam("especialidade") String especialidade){
      Especialidade nEspec = new Especialidade();
      nEspec.setEspecialidade(especialidade);
      eR.save(nEspec);
      return "redirect:/especialidade";
     }


     @PostMapping("/especialidade/{especialidade_id}")
      public String delete(@RequestParam("id") Integer id) {
      eR.deleteById(id);
      return "redirect:/especialidade";
   }

}