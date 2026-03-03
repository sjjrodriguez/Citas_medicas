package com.example.demo.Service;

import com.example.demo.Model.Paciente;
import com.example.demo.Repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceIMP implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceIMP(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public Paciente actualizar(Long id, Paciente paciente) {
        if (!pacienteRepository.existsById(id)) {
            return null;
        }
        paciente.setIdPaciente(id);
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente buscarPorDocumento(String documento) {
        return pacienteRepository.findByDocumento(documento).orElse(null);
    }
}
