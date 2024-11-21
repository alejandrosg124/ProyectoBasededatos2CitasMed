package com.citasMed.citas.Neo4J.controllerNeo;

import com.citasMed.citas.Neo4J.modelNeo.CitaNeo;
import com.citasMed.citas.Neo4J.serviceNeo.CitaNeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/neo4j/citas")
public class CitaNeoController {

    private final CitaNeoService citaNeoService;

    public CitaNeoController(CitaNeoService citaNeoService) {
        this.citaNeoService = citaNeoService;
    }

    @PostMapping
    public ResponseEntity<CitaNeo> registrarCita(@RequestBody CitaNeo cita) {
        return ResponseEntity.ok(citaNeoService.registrarCita(cita));
    }
}
