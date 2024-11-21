package com.citasMed.citas.Neo4J.modelNeo;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Node
public class MedicoNeo {

    @Id
    private String id;
    private String name;
    private String especialidad;

    @Relationship(type = "ATIENDE")
    private Set<CitaNeo> citas;

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public Set<CitaNeo> getCitas() { return citas; }
    public void setCitas(Set<CitaNeo> citas) { this.citas = citas; }
}
