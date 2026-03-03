package com.example.demo.Service;

import com.example.demo.Model.Examen;
import com.example.demo.Repository.ExamenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceIMP implements ExamenService {

    private final ExamenRepository examenRepository;

    public ExamenServiceIMP(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public List<Examen> listarPorPaciente(Long idPaciente) {
        return examenRepository.findByPacienteIdPaciente(idPaciente);
    }

    @Override
    public Examen guardar(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen obtenerPorId(Long idExamen) {
        return examenRepository.findById(idExamen).orElse(null);
    }

    @Override
    public Examen actualizar(Long idExamen, Examen examen) {
        if (!examenRepository.existsById(idExamen)) {
            return null;
        }
        examen.setIdExamen(idExamen);
        return examenRepository.save(examen);
    }

    @Override
    public void eliminar(Long idExamen) {
        examenRepository.deleteById(idExamen);
    }
}
