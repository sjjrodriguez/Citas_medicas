package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    // RNF-02: El documento debe ser único, no se permiten duplicados
    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String email;

    // Relación 1 a 1: cada paciente tiene exactamente un usuario para login
    // Si se elimina el usuario, se elimina el paciente también
    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Paciente() {}

    public Paciente(Long idPaciente, String documento, String nombre,
                    String telefono, String email, Usuario usuario) {
        this.idPaciente = idPaciente;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
