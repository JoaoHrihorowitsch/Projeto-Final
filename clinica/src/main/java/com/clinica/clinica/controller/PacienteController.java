package com.clinica.clinica.controller;

import com.clinica.clinica.model.*;
import com.clinica.clinica.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PacienteController {

   @Autowired
   private PacienteRepository pR;

   @Autowired
   private ConvenioRepository cR;

   
    @GetMapping("/paciente")
    public String listar(Model model){
      List<Paciente> paciente = pR.findAll();
      model.addAttribute("paciente", paciente);
      return "paciente/home";
    }


    @GetMapping("/novoPaciente")
    public String create(Model model){
      List<Convenio> convenio = cR.findAll();
      model.addAttribute("convenio", convenio);
      model.addAttribute("paciente", new Paciente());
        return "paciente/create";
    }

    @PostMapping("/novoPaciente")
    public String save(@ModelAttribute Paciente paciente, Model model){
      Paciente pac = new Paciente();
      pac.setCpf(paciente.getCpf());
      pac.setNome(paciente.getNome());
      pac.setEmail(paciente.getEmail());
      pac.setConvenio(paciente.getConvenio());
      pac.setTelefone(paciente.getTelefone());
      pac.setNascimento(paciente.getNascimento());
      pac.setCep(paciente.getCep());
      pac.setEndereco(paciente.getEndereco());
      pac.setComplemento(paciente.getComplemento());
      pac.setBairro(paciente.getBairro());
      pac.setCidade(paciente.getCidade());
      pac.setEstado(paciente.getEstado());
      pR.save(pac);

      return "redirect:/paciente";
    }

    @PostMapping("/paciente/{paciente_cpf}")
    @Transactional
      public String delete(@PathVariable("paciente_cpf") Long cpf) {
      pR.deleteByCpf(cpf.longValue());
      return "redirect:/paciente";
   }

   @GetMapping("/paciente/{paciente_cpf}/editar")
   public String edit(@PathVariable("paciente_cpf") long cpf, Model model ){
      Paciente paciente = pR.findByCpf(cpf);
      model.addAttribute("paciente", paciente);

      return "paciente/edit";

   }

}
