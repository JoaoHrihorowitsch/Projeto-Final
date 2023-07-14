package com.clinica.clinica.controller;

import java.util.List;
import java.util.Optional;

import com.clinica.clinica.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinica.clinica.repository.*;

@Controller
public class ConsultaContoller {

   @Autowired
    ConsultaRepository coR;

    @Autowired
    EspecialidadeRepository eR;

    @Autowired
    MedicoRepository mR;

    @Autowired
    PacienteRepository pR;

   @GetMapping("/consulta")
   public String listar(Model model) {
      List<Consulta> consulta = coR.findAll();
      model.addAttribute ("consulta", consulta);
        return "consulta/home";
     }

   @GetMapping("/novaConsulta")
   public String create(Model model) {
      List<Especialidade> especialidades = eR.findAll();
      model.addAttribute("especialidades", especialidades);
      List<Medico> medico = mR.findAll();
      model.addAttribute("medico", medico);
      List<Paciente> paciente = pR.findAll();
      model.addAttribute("paciente", paciente);
      model.addAttribute("consulta", new Consulta());
        return "consulta/create";
     }

   @PostMapping("/novaConsulta")
   public String save (@ModelAttribute Consulta consulta, Model model){
      Consulta con = new Consulta();

      con.setHora(consulta.getHora());
      con.setData(consulta.getData());
      con.setMedico(consulta.getMedico());
      con.setPaciente(consulta.getPaciente());
      con.setEspecialidade(consulta.getEspecialidade());
      coR.save(con);
      return "redirect:/consulta";

   }

   @PostMapping("/consulta/{consulta_id}")
   public String delete(@PathVariable("consulta_id") Integer id) {
      coR.deleteById(id);
      return "redirect:/consulta";
  }

   @GetMapping("/consulta/{consulta_id}/editar")
   public String edit(@PathVariable("consulta_id") Integer id, Model model) {
      List<Especialidade> especialidades = eR.findAll();
      model.addAttribute("especialidades", especialidades);
      List<Medico> medico = mR.findAll();
      model.addAttribute("medico", medico);
      List<Paciente> paciente = pR.findAll();
      model.addAttribute("paciente", paciente);
      Optional<Consulta> cO = coR.findById(id);
      Consulta consulta = cO.orElse(null);
      model.addAttribute("consulta", consulta);
      return "consulta/edit";
   }

   @PostMapping("/consulta/{consulta_id}/editar")
   public String saveEdit(@ModelAttribute Consulta c, Model model){
      Consulta con = new Consulta();

      con.setId(c.getId());
      con.setHora(c.getHora());
      con.setData(c.getData());
      con.setMedico(c.getMedico());
      con.setPaciente(c.getPaciente());
      con.setEspecialidade(c.getEspecialidade());
      coR.save(con);
      return"redirect:/consulta";
   }

}
