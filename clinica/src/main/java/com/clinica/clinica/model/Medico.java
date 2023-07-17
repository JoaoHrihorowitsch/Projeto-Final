package com.clinica.clinica.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Medico {
	
	@Id
	@Column(nullable = false)
	private long crm;
	@Column(nullable = false)
	private String nome;
	private String endereco;
	private int cep;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	@Column(nullable = false)
	private int tel;

	@OneToMany(mappedBy = "medico")
    private List<Consulta> consulta;

	@ManyToOne
	@JoinColumn (name = "especialidade")
	private Especialidade especialidade;


	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public Medico () {
		
	}
	
	public Medico(long crm, String nome, String endereco, int cep, String complemento, String bairro, String cidade, String estado, int tel) {
		this.crm = crm;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.tel = tel;
	}


	public long getCrm() {
		return this.crm;
	}

	public void setCrm(long crm) {
		this.crm = crm;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCep() {
		return this.cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTel() {
		return this.tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

}
	