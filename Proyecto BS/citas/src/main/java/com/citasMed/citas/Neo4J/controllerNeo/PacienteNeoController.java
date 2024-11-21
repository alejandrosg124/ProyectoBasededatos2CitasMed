package com.citasMed.citas.Neo4J.controllerNeo;

import com.citasMed.citas.Neo4J.modelNeo.PacienteNeo;
import com.citasMed.citas.Neo4J.serviceNeo.PacienteNeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neo4j/pacientes")
public class PacienteNeoController {

    private final PacienteNeoService pacienteNeoService;

    public PacienteNeoController(PacienteNeoService pacienteNeoService) {
        this.pacienteNeoService = pacienteNeoService;
    }

    @PutMapping("/prioridad")
    public ResponseEntity<List<PacienteNeo>> cambiarPrioridadAlta() {
        return ResponseEntity.ok(pacienteNeoService.cambiarPrioridadAlta());
    }

    @GetMapping("/mayores-65")
    public ResponseEntity<List<PacienteNeo>> consultarMayores65PorEps(@RequestParam String eps) {
    List<PacienteNeo> pacientes = pacienteNeoService.consultarMayores65PorEps(eps);
    return ResponseEntity.ok(pacientes);
    }

}
