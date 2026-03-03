package com.example.demo.Repository;

import com.example.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // metodo Buscar usuario por username
    Optional<Usuario> findByUsername(String username);

    // metodo Verificar si un username ya existe
    boolean existsByUsername(String username);

    // metodo para Verificar si un DNI ya esta registrado
    boolean existsByDni(String dni);
}
