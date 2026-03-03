package com.example.demo.Controller;

import com.example.demo.Model.Cita;
import com.example.demo.Service.CitaServiceIMP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaServiceIMP citaService;

    public CitaController(CitaServiceIMP citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cita>> listar() {
        return ResponseEntity.ok(citaService.listar());
    }

    @GetMapping("/listar/paciente/{idPaciente}")
    public ResponseEntity<List<Cita>> listarPorPaciente(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(citaService.listarPorPaciente(idPaciente));
    }

    @GetMapping("/listar/doctor/{idDoctor}")
    public ResponseEntity<List<Cita>> listarPorDoctor(@PathVariable Long idDoctor) {
        return ResponseEntity.ok(citaService.listarPorDoctor(idDoctor));
    }

    @PostMapping("/programar")
    public ResponseEntity<?> programar(@RequestBody Cita cita) {
        Cita citaProgramada = citaService.programar(cita);
        if (citaProgramada == null) {
            return ResponseEntity.status(409).body("Conflicto de horario");
        }
        return ResponseEntity.status(201).body(citaProgramada);
    }

    @PutMapping("/cancelar/{idCita}")
    public ResponseEntity<Cita> cancelar(@PathVariable Long idCita) {
        Cita citaCancelada = citaService.cancelar(idCita);
        if (citaCancelada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(citaCancelada);
    }

    @GetMapping("/obtener/{idCita}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long idCita) {
        Cita cita = citaService.obtenerPorId(idCita);
        if (cita == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cita);
    }
}
