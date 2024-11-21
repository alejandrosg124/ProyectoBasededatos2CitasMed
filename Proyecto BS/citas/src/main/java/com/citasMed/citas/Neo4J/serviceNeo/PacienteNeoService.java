package com.citasMed.citas.Neo4J.serviceNeo;

import com.citasMed.citas.Neo4J.modelNeo.PacienteNeo;
import com.citasMed.citas.Neo4J.repositoryNeo.PacienteNeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PacienteNeoService {

    private final PacienteNeoRepository pacienteNeoRepository;

    public PacienteNeoService(PacienteNeoRepository pacienteNeoRepository) {
        this.pacienteNeoRepository = pacienteNeoRepository;
    }

    public List<PacienteNeo> cambiarPrioridadAlta() {
        String query = """
            MATCH (p:Paciente)
            WHERE p.edad > 65 AND p.condicionSalud IN ['Hipertensión', 'Diabetes', 'Cáncer']
            SET p.prioridad = 'Alta'
            RETURN p
        """;
        return pacienteNeoRepository.executeCustomQueryWithParams(query, Map.of());
    }

    public List<PacienteNeo> consultarPorRangoEdadYEps(int edadMin, int edadMax, String eps) {
        String query = """
            MATCH (p:Paciente)
            WHERE p.edad >= $edadMin AND p.edad <= $edadMax AND p.eps = $eps
            RETURN p
        """;
        return pacienteNeoRepository.executeCustomQueryWithParams(query, Map.of(
            "edadMin", edadMin,
            "edadMax", edadMax,
            "eps", eps
        ));
    }

    public List<PacienteNeo> consultarMayores65PorEps(String eps) {
        String query = """
            MATCH (p:Paciente)
            WHERE p.edad > 65 AND p.eps = $eps
            RETURN p
        """;
    
        return pacienteNeoRepository.executeCustomQueryWithParams(query, Map.of("eps", eps));
    }
    
    
}
