package com.example.demo.Repository;

import com.example.demo.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // metodo para buscar paciente por el id del usuario asociado
    Optional<Paciente> findByUsuarioIdUsuario(Long idUsuario);

    // metodo para buscar paciente por documento (RNF-02)
    Optional<Paciente> findByDocumento(String documento);
}
