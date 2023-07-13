package com.clinica.clinica.controller;
import com.clinica.clinica.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.clinica.repository.ConvenioRepository;


@Controller
public class ConvenioController {

    @Autowired
    private ConvenioRepository cR;

    
   @GetMapping("/convenio")
     public String listar(Model model) {
      List<Convenio> conv = cR.findAll();
      model.addAttribute("convenio", conv);
        return "convenio/home";
     }

    @GetMapping("/novoConvenio")
     public String create(Model model) {
      model.addAttribute("convenio", new Convenio());
        return "convenio/create";
     }

     @PostMapping("/novoConvenio")
     public String save(@RequestParam("convenio") String convenio){
      Convenio cn = new Convenio();
      cn.setPlano(convenio);
      cR.save(cn);
      return "redirect:/convenio";
     }

     @PostMapping("/convenio/{convenio_id}")
     public String delete(@RequestParam("id") Integer id){
      cR.deleteById(id);
      return "redirect:/convenio";
     }

     @GetMapping("/pesquisarConvenio")
     public String pesquisar(@RequestParam("pesquisa") String pesquisa, Model model){
      List<Convenio> resultado = cR.findByPlano(pesquisa);
     model.addAttribute("convenio", resultado);
     return "convenio/home";
     }
}


