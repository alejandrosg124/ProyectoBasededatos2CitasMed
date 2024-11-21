package com.citasMed.citas.Neo4J.controllerNeo;

import com.citasMed.citas.Neo4J.modelNeo.MedicoNeo;
import com.citasMed.citas.Neo4J.serviceNeo.MedicoNeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/neo4j/medicos")
public class MedicoNeoController {

    private final MedicoNeoService medicoNeoService;

    public MedicoNeoController(MedicoNeoService medicoNeoService) {
        this.medicoNeoService = medicoNeoService;
    }

    @PostMapping
    public ResponseEntity<MedicoNeo> registrarMedico(@RequestBody MedicoNeo medico) {
        return ResponseEntity.ok(medicoNeoService.registrarMedico(medico));
    }
}
