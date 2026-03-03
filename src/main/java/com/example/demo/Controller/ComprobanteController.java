package com.example.demo.Controller;

import com.example.demo.Model.Comprobante;
import com.example.demo.Service.ComprobanteServiceIMP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {

    private final ComprobanteServiceIMP comprobanteService;

    public ComprobanteController(ComprobanteServiceIMP comprobanteService) {
        this.comprobanteService = comprobanteService;
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Comprobante> obtenerPorId(@PathVariable Long id) {
        Comprobante comprobante = comprobanteService.obtenerPorId(id);
        if (comprobante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comprobante);
    }

    @GetMapping("/verificar/{codigo}")
    public ResponseEntity<Comprobante> verificar(@PathVariable String codigo) {
        Comprobante comprobante = comprobanteService.buscarPorCodigo(codigo);
        if (comprobante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comprobante);
    }

    @GetMapping("/cita/{idCita}")
    public ResponseEntity<Comprobante> buscarPorCita(@PathVariable Long idCita) {
        Comprobante comprobante = comprobanteService.buscarPorCita(idCita);
        if (comprobante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comprobante);
    }
}
