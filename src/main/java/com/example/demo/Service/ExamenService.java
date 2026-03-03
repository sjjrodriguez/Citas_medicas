package com.example.demo.Service;

import com.example.demo.Model.Examen;
import java.util.List;

public interface ExamenService {

    // metodo para listar examenes de un paciente
    List<Examen> listarPorPaciente(Long idPaciente);

    // metodo guardar examen
    Examen guardar(Examen examen);

    // metodo obtener examen por ID
    Examen obtenerPorId(Long idExamen);

    // metodo actualizar examen
    Examen actualizar(Long idExamen, Examen examen);

    // metodo eliminar examen
    void eliminar(Long idExamen);
}
