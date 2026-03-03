package com.example.demo.Repository;

import com.example.demo.Model.Cita;
import com.example.demo.Model.Cita.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    // Metodo listar citas de un paciente
    List<Cita> findByPacienteIdPaciente(Long idPaciente);

    // Metodo listar citas de un doctor en especifico
    List<Cita> findByDoctorIdDoctor(Long idDoctor);

    // Metodo Verificar conflicto de horario
    boolean existsByDoctorIdDoctorAndEstadoAndInicioLessThanAndFinGreaterThan(
            Long idDoctor, EstadoCita estado, LocalDateTime fin, LocalDateTime inicio);
}
