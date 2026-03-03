package com.example.demo.Controller;

import com.example.demo.Model.Paciente;
import com.example.demo.Service.PacienteServiceIMP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteServiceIMP pacienteService;

    public PacienteController(PacienteServiceIMP pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listar() {
        return ResponseEntity.ok(pacienteService.listar());
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<Paciente> buscarPorDocumento(@PathVariable String documento) {
        Paciente paciente = pacienteService.buscarPorDocumento(documento);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        Paciente pacienteGuardado = pacienteService.guardar(paciente);
        return ResponseEntity.status(201).body(pacienteGuardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteActualizado = pacienteService.actualizar(id, paciente);
        if (pacienteActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pacienteActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Paciente> eliminar(@PathVariable Long id,
                                             @RequestParam(required = false, defaultValue = "false") boolean confirmar) {
        Paciente paciente = pacienteService.obtenerPorId(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }
        if (confirmar) {
            pacienteService.eliminar(id);
        }
        return ResponseEntity.ok(paciente);
    }
}
