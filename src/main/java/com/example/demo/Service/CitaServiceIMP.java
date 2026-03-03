package com.example.demo.Service;

import com.example.demo.Model.Cita;
import com.example.demo.Model.Cita.EstadoCita;
import com.example.demo.Model.Comprobante;
import com.example.demo.Model.Comprobante.TipoComprobante;
import com.example.demo.Repository.CitaRepository;
import com.example.demo.Repository.ComprobanteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaServiceIMP implements CitaService {

    private final CitaRepository citaRepository;
    private final ComprobanteRepository comprobanteRepository;

    public CitaServiceIMP(CitaRepository citaRepository, ComprobanteRepository comprobanteRepository) {
        this.citaRepository = citaRepository;
        this.comprobanteRepository = comprobanteRepository;
    }

    @Override
    public List<Cita> listarPorPaciente(Long idPaciente) {
        return citaRepository.findByPacienteIdPaciente(idPaciente);
    }

    @Override
    public List<Cita> listarPorDoctor(Long idDoctor) {
        return citaRepository.findByDoctorIdDoctor(idDoctor);
    }

    @Override
    public Cita programar(Cita cita) {
        boolean hayConflicto = citaRepository
                .existsByDoctorIdDoctorAndEstadoAndInicioLessThanAndFinGreaterThan(
                        cita.getDoctor().getIdDoctor(),
                        EstadoCita.PROGRAMADA,
                        cita.getFin(),
                        cita.getInicio()
                );
        if (hayConflicto) {
            return null;
        }
        cita.setEstado(EstadoCita.PROGRAMADA);
        Cita citaGuardada = citaRepository.save(cita);

        Comprobante comprobante = new Comprobante(
                null,
                TipoComprobante.PROGRAMACION,
                citaGuardada,
                LocalDateTime.now()
        );
        comprobanteRepository.save(comprobante);

        return citaGuardada;
    }

    @Override
    public Cita cancelar(Long idCita) {
        Cita cita = citaRepository.findById(idCita).orElse(null);
        if (cita == null) {
            return null;
        }
        if (cita.getEstado() != EstadoCita.PROGRAMADA) {
            return null;
        }
        cita.setEstado(EstadoCita.CANCELADA);
        Cita citaCancelada = citaRepository.save(cita);

        Comprobante comprobante = new Comprobante(
                null,
                TipoComprobante.CANCELACION,
                citaCancelada,
                LocalDateTime.now()
        );
        comprobanteRepository.save(comprobante);

        return citaCancelada;
    }

    @Override
    public Cita obtenerPorId(Long idCita) {
        return citaRepository.findById(idCita).orElse(null);
    }

    @Override
    public List<Cita> listar() {
        return citaRepository.findAll();
    }
}
