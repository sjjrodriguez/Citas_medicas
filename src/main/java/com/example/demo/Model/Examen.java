package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String resultado;

    @Column
    private String observaciones;

    public Examen() {
    }

    public Examen(Long idExamen, Paciente paciente, String tipo, LocalDate fecha, String resultado, String observaciones) {
        this.idExamen = idExamen;
        this.paciente = paciente;
        this.tipo = tipo;
        this.fecha = fecha;
        this.resultado = resultado;
        this.observaciones = observaciones;
    }

    public Long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Long idExamen) {
        this.idExamen = idExamen;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "idExamen=" + idExamen +
                ", paciente=" + paciente +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", resultado='" + resultado + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
