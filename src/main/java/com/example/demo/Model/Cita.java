package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;


    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;


    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private String especialidad;


    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estado;


    public enum EstadoCita {
        PROGRAMADA,
        CANCELADA,
        COMPLETADA
    }


    public Cita() {}


    public Cita(Long idCita, Paciente paciente, Doctor doctor, String especialidad,
                LocalDateTime inicio, LocalDateTime fin, EstadoCita estado) {
        this.idCita = idCita;
        this.paciente = paciente;
        this.doctor = doctor;
        this.especialidad = especialidad;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
    }

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", paciente=" + paciente +
                ", doctor=" + doctor +
                ", especialidad='" + especialidad + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", estado=" + estado +
                '}';
    }
}
