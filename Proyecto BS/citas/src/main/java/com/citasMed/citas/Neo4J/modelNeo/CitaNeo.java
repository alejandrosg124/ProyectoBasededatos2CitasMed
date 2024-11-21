package com.citasMed.citas.Neo4J.modelNeo;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;

@Node
public class CitaNeo {

    @Id
    private String id;
    private String name;
    private LocalDateTime fechaHora;
    private String motivo;

    @Relationship(type = "TIENE_CITA", direction = Relationship.Direction.INCOMING)
    private PacienteNeo paciente;

    @Relationship(type = "ATIENDE", direction = Relationship.Direction.INCOMING)
    private MedicoNeo medico;

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public PacienteNeo getPaciente() { return paciente; }
    public void setPaciente(PacienteNeo paciente) { this.paciente = paciente; }
    public MedicoNeo getMedico() { return medico; }
    public void setMedico(MedicoNeo medico) { this.medico = medico; }
}
