package com.clinica.clinica.model;

import java.time.LocalTime;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;
    private Date data;
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name="medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="especialidade")
    private Especialidade especialidade;

    @ManyToOne
    @JoinColumn(name = "paciente")
    private Paciente paciente;



    public Consulta() {
    }

    public Consulta(Integer id, Date data, LocalTime hora, Medico medico, Especialidade especialidade, Paciente paciente) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.especialidade = especialidade;
        this.paciente = paciente;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return this.hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return this.medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consulta id(Integer id) {
        setId(id);
        return this;
    }

    public Consulta data(Date data) {
        setData(data);
        return this;
    }

    public Consulta hora(LocalTime hora) {
        setHora(hora);
        return this;
    }

    public Consulta medico(Medico medico) {
        setMedico(medico);
        return this;
    }

    public Consulta especialidade(Especialidade especialidade) {
        setEspecialidade(especialidade);
        return this;
    }

    public Consulta paciente(Paciente paciente) {
        setPaciente(paciente);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Consulta)) {
            return false;
        }
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id) && Objects.equals(data, consulta.data) && Objects.equals(hora, consulta.hora) && Objects.equals(medico, consulta.medico) && Objects.equals(especialidade, consulta.especialidade) && Objects.equals(paciente, consulta.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, hora, medico, especialidade, paciente);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", data='" + getData() + "'" +
            ", hora='" + getHora() + "'" +
            ", medico='" + getMedico() + "'" +
            ", especialidade='" + getEspecialidade() + "'" +
            ", paciente='" + getPaciente() + "'" +
            "}";
    }
   
}