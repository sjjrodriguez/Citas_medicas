package com.example.demo.Service;

import com.example.demo.Model.Doctor;
import java.util.List;

public interface DoctorService {

    // metodo listar doctores
    List<Doctor> listar();

    // metodo guardar nuevo doctor
    Doctor guardar(Doctor doctor);

    // metodo obtener doctor por ID
    Doctor obtenerPorId(Long id);

    // metodo actualizar doctor
    Doctor actualizar(Long id, Doctor doctor);

    // metodo eliminar doctor
    void eliminar(Long id);

    // metodo buscar doctores por especialidad
    List<Doctor> listarPorEspecialidad(String especialidad);
}
