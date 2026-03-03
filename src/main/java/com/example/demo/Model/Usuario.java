package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental en MySQL
    private Long idUsuario;

    @Column(nullable = false, unique = true) // No puede ser nulo ni repetido
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolUsuario rol;

    // Enum que define los 3 tipos de usuario posibles en el sistema
    public enum RolUsuario {
        PACIENTE, // Puede consultar citas, exámenes, programar y cancelar
        DOCTOR,   // Tiene citas asignadas y puede ver exámenes
        ADMIN     // Acceso total al sistema
    }

    public Usuario() {}

    public Usuario(Long idUsuario, String username, String password, String dni,
                   String nombre, String email, RolUsuario rol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public RolUsuario getRol() { return rol; }
    public void setRol(RolUsuario rol) { this.rol = rol; }
}
