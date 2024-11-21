package com.citasMed.citas.Neo4J.serviceNeo;

import com.citasMed.citas.Neo4J.modelNeo.CitaNeo;
import com.citasMed.citas.Neo4J.repositoryNeo.CitaNeoRepository;
import com.citasMed.citas.Neo4J.repositoryNeo.PacienteNeoRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CitaNeoService {

    private final CitaNeoRepository citaNeoRepository;
    private final PacienteNeoRepository pacienteNeoRepository;

    public CitaNeoService(CitaNeoRepository citaNeoRepository, PacienteNeoRepository pacienteNeoRepository) {
        this.citaNeoRepository = citaNeoRepository;
        this.pacienteNeoRepository = pacienteNeoRepository;
    }

    public CitaNeo registrarCita(CitaNeo cita) {
        return citaNeoRepository.save(cita);
    }

    public void cambiarPrioridadAlta() {
        String query = """
            MATCH (p:Paciente)
            WHERE p.edad > 65 AND p.condicionSalud IN ['Hipertensión', 'Diabetes', 'Cáncer']
            SET p.prioridad = 'Alta'
            RETURN p
        """;
        pacienteNeoRepository.executeCustomQuery(query);
    }

    public void registrarCita(String pacienteId, String medicoId, CitaNeo cita) {
        String createCitaQuery = """
            CREATE (c:Cita {id: $id, name: $name, fechaHora: $fechaHora, motivo: $motivo})
        """;
        citaNeoRepository.executeCustomQueryWithParams(createCitaQuery, Map.of(
            "id", cita.getId(),
            "name", cita.getName(),
            "fechaHora", cita.getFechaHora(),
            "motivo", cita.getMotivo()
        ));

        String linkPacienteQuery = """
            MATCH (p:Paciente {id: $pacienteId}), (c:Cita {id: $citaId})
            CREATE (p)-[:TIENE_CITA]->(c)
        """;
        citaNeoRepository.executeCustomQueryWithParams(linkPacienteQuery, Map.of(
            "pacienteId", pacienteId,
            "citaId", cita.getId()
        ));

        String linkMedicoQuery = """
            MATCH (m:Medico {id: $medicoId}), (c:Cita {id: $citaId})
            CREATE (m)-[:ATIENDE]->(c)
        """;
        citaNeoRepository.executeCustomQueryWithParams(linkMedicoQuery, Map.of(
            "medicoId", medicoId,
            "citaId", cita.getId()
        ));
    }
}
