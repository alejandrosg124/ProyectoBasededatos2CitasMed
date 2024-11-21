package com.citasMed.citas.controller;

import com.citasMed.citas.model.Cita;
import com.citasMed.citas.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;
    
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @PostMapping
    public ResponseEntity<Cita> registrarCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.registrarCita(cita));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable String id, @RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.actualizarCita(id, cita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable String id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }

}
