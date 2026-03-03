package com.example.demo.Service;

import com.example.demo.Model.Cita;
import java.util.List;

public interface CitaService {

    // metodo para listar citas de un paciente específico
    List<Cita> listarPorPaciente(Long idPaciente);

    // metodo listar citas de un doctor específico
    List<Cita> listarPorDoctor(Long idDoctor);

    // metodo programar nueva cita
    Cita programar(Cita cita);

    // metodo cancelar cita
    Cita cancelar(Long idCita);

    // metodo obtener cita por ID
    Cita obtenerPorId(Long idCita);

    // metodo listar todas las citas
    List<Cita> listar();
}
