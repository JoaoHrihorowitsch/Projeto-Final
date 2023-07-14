package com.clinica.clinica.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Paciente {

    @Id
    @Column(nullable = false)
    private long cpf;
    @Column(nullable = false)
    private String nascimento;
    @Column(nullable = false)
    private String nome;
    private String email;
    @Column(nullable = false)
    private int telefone;
    private String endereco;
	private int cep;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consulta;

    @ManyToOne(optional = true)
	@JoinColumn (name = "convenio")
	private Convenio convenio;

    public Convenio getConvenio() {
        return this.convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }


    public Paciente() { }

    public Paciente(long cpf, String nascimento, String nome, String email, int telefone, String endereco, int cep, String complemento, String bairro, String cidade, String estado) {
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
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
}
   