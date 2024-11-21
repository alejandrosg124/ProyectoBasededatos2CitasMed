package com.citasMed.citas.controller;

import com.citasMed.citas.model.Paciente;
import com.citasMed.citas.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PutMapping("/prioridad")
    public ResponseEntity<Void> cambiarPrioridad() {
        pacienteService.cambiarPrioridadAlta();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rango-edad")
    public ResponseEntity<List<Paciente>> consultarPorRangoEdadYeps(
            @RequestParam int edadMin,
            @RequestParam int edadMax,
            @RequestParam String eps) {
        return ResponseEntity.ok(pacienteService.consultarPorRangoEdadYeps(edadMin, edadMax, eps));
    }

    @GetMapping("/mayores-65")
    public ResponseEntity<List<Paciente>> consultarMayores65PorEps(@RequestParam String eps) {
        return ResponseEntity.ok(pacienteService.consultarMayores65PorEps(eps));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable String id, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.actualizarPaciente(id, paciente));
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable String id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }
}
