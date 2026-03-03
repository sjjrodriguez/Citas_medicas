package com.example.demo.Repository;

import com.example.demo.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    // metodo para buscar doctores por especialidad (RF-03: programar cita por especialidad)
    List<Doctor> findByEspecialidad(String especialidad);

    // metodo para buscar doctor por su usuario asociado
    Optional<Doctor> findByUsuarioIdUsuario(Long idUsuario);
}
