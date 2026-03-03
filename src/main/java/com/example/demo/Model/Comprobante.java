package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comprobantes")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprobante;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoComprobante tipo;


    @OneToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @Column(nullable = false)
    private LocalDateTime fechaEmision;


    @Column(nullable = false, unique = true)
    private String codigoVerificable;


    public enum TipoComprobante {
        PROGRAMACION,
        CANCELACION
    }

    // Constructor vacío: genera un codigoVerificable único automáticamente
    // para que siempre haya un código aunque no se pase por constructor
    public Comprobante() {
        this.codigoVerificable = UUID.randomUUID().toString();
    }

    // El codigoVerificable se genera automáticamente con UUID (no se pasa como parámetro)
    public Comprobante(Long idComprobante, TipoComprobante tipo,
                       Cita cita, LocalDateTime fechaEmision) {
        this.idComprobante = idComprobante;
        this.tipo = tipo;
        this.cita = cita;
        this.fechaEmision = fechaEmision;
        this.codigoVerificable = UUID.randomUUID().toString(); // Siempre único
    }

    public Long getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Long idComprobante) {
        this.idComprobante = idComprobante;
    }

    public TipoComprobante getTipo() {
        return tipo;
    }

    public void setTipo(TipoComprobante tipo) {
        this.tipo = tipo;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getCodigoVerificable() {
        return codigoVerificable;
    }

    public void setCodigoVerificable(String codigoVerificable) {
        this.codigoVerificable = codigoVerificable;
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "idComprobante=" + idComprobante +
                ", tipo=" + tipo +
                ", cita=" + cita +
                ", fechaEmision=" + fechaEmision +
                ", codigoVerificable='" + codigoVerificable + '\'' +
                '}';
    }
}
