package com.clinica.clinica.controller;

import com.clinica.clinica.repository.*;
import com.clinica.clinica.model.*;

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
public class MedicoController {

    @Autowired
    private MedicoRepository meR;

    @Autowired
    private EspecialidadeRepository eR;

    @GetMapping("/medico")
    public String listar(Model model){
      List<Medico> med = meR.findAll();
      model.addAttribute("medico", med);
      return "medico/home";
    }

    @GetMapping("/novoMedico")
    public String create(Model model){
      List<Especialidade> especialidades = eR.findAll();
      model.addAttribute("especialidades", especialidades);
      model.addAttribute("medico", new Medico());
        return "medico/create";
    }

    @PostMapping("/novoMedico")
    public String save(@ModelAttribute Medico medico, Model model){
      Medico med = new Medico();
      med.setCrm(medico.getCrm());
      med.setNome(medico.getNome());
      med.setEspecialidade(medico.getEspecialidade());
      med.setTel(medico.getTel());
      med.setCep(medico.getCep());
      med.setEndereco(medico.getEndereco());
      med.setComplemento(medico.getComplemento());
      med.setBairro(medico.getBairro());
      med.setCidade(medico.getCidade());
      med.setEstado(medico.getEstado());
      meR.save(med);
      return "redirect:/medico";
    }

    @PostMapping("/medico/{medico_crm}")
    @Transactional
      public String delete(@PathVariable("medico_crm") Long crm) {
      meR.deleteByCrm(crm.longValue());
      return "redirect:/medico";
   }

    @GetMapping("/medico/{medico_crm}/editar")
      public String edit(@PathVariable("medico_crm") long crm, Model model ){
      List<Especialidade> especialidades = eR.findAll();
      model.addAttribute("especialidades", especialidades);
      Medico medico = meR.findByCrm(crm);
      model.addAttribute("medico", medico);

      return "medico/edit";

   }




}
    

