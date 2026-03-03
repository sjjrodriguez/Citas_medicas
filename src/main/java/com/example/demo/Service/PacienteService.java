package com.example.demo.Service;

import com.example.demo.Model.Paciente;
import java.util.List;

public interface PacienteService {

    // metodo listar pacientes
    List<Paciente> listar();

    // metodo guardar nuevo paciente
    Paciente guardar(Paciente paciente);

    // metodo obtener paciente por ID
    Paciente obtenerPorId(Long id);

    // metodo actualizar paciente
    Paciente actualizar(Long id, Paciente paciente);

    // metodo eliminar paciente
    void eliminar(Long id);

    // metodo buscar paciente por documento
    Paciente buscarPorDocumento(String documento);
}
