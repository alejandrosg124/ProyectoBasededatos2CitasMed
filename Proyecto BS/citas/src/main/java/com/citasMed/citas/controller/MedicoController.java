package com.citasMed.citas.controller;

import com.citasMed.citas.model.Medico;
import com.citasMed.citas.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Medico> registrarMedico(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.registrarMedico(medico));
    }
}
