package com.example.demo.Repository;

import com.example.demo.Model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {

    // Metodo para Consultar examenes de un paciente
    List<Examen> findByPacienteIdPaciente(Long idPaciente);

}
