package com.example.demo.Controller;

import com.example.demo.Model.Examen;
import com.example.demo.Service.ExamenServiceIMP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {

    private final ExamenServiceIMP examenService;

    public ExamenController(ExamenServiceIMP examenService) {
        this.examenService = examenService;
    }

    @GetMapping("/listar/paciente/{idPaciente}")
    public ResponseEntity<List<Examen>> listarPorPaciente(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(examenService.listarPorPaciente(idPaciente));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Examen> guardar(@RequestBody Examen examen) {
        Examen examenGuardado = examenService.guardar(examen);
        return ResponseEntity.status(201).body(examenGuardado);
    }

    @GetMapping("/obtener/{idExamen}")
    public ResponseEntity<Examen> obtenerPorId(@PathVariable Long idExamen) {
        Examen examen = examenService.obtenerPorId(idExamen);
        if (examen == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(examen);
    }

    @PutMapping("/actualizar/{idExamen}")
    public ResponseEntity<Examen> actualizar(@PathVariable Long idExamen, @RequestBody Examen examen) {
        Examen examenActualizado = examenService.actualizar(idExamen, examen);
        if (examenActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(examenActualizado);
    }

    @DeleteMapping("/eliminar/{idExamen}")
    public ResponseEntity<Examen> eliminar(@PathVariable Long idExamen,
                                           @RequestParam(required = false, defaultValue = "false") boolean confirmar) {
        Examen examen = examenService.obtenerPorId(idExamen);
        if (examen == null) {
            return ResponseEntity.notFound().build();
        }
        if (confirmar) {
            examenService.eliminar(idExamen);
        }
        return ResponseEntity.ok(examen);
    }
}
