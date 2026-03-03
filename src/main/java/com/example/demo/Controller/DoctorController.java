package com.example.demo.Controller;

import com.example.demo.Model.Doctor;
import com.example.demo.Service.DoctorServiceIMP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final DoctorServiceIMP doctorService;

    public DoctorController(DoctorServiceIMP doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Doctor>> listar() {
        return ResponseEntity.ok(doctorService.listar());
    }

    @GetMapping("/especialidad/{especialidad}")
    public ResponseEntity<List<Doctor>> listarPorEspecialidad(@PathVariable String especialidad) {
        return ResponseEntity.ok(doctorService.listarPorEspecialidad(especialidad));
    }

    @PostMapping("/guardar")
    public ResponseEntity<Doctor> guardar(@RequestBody Doctor doctor) {
        Doctor doctorGuardado = doctorService.guardar(doctor);
        return ResponseEntity.status(201).body(doctorGuardado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Doctor> actualizar(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor doctorActualizado = doctorService.actualizar(id, doctor);
        if (doctorActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctorActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Doctor> eliminar(@PathVariable Long id,
                                           @RequestParam(required = false, defaultValue = "false") boolean confirmar) {
        Doctor doctor = doctorService.obtenerPorId(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        if (confirmar) {
            doctorService.eliminar(id);
        }
        return ResponseEntity.ok(doctor);
    }
}
