package com.clinica.clinica.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Convenio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String plano;

	@OneToMany(mappedBy = "convenio")
    private List<Paciente> paciente;


	public List<Paciente> getPaciente() {
		return this.paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}


	public Convenio() {}

	public Convenio(Integer id, String plano) {
		this.id = id;
		this.plano = plano;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlano() {
		return this.plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}



}