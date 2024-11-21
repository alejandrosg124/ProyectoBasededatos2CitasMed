package com.citasMed.citas.Neo4J.modelNeo;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@Node
public class PacienteNeo {

    @Id
    private String id;
    private String name;
    private int edad;
    private String genero;
    private String eps;
    private String prioridad;
    private String condicionSalud;

    @Relationship(type = "TIENE_CITA")
    private Set<CitaNeo> citas;

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getEps() { return eps; }
    public void setEps(String eps) { this.eps = eps; }
    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
    public String getCondicionSalud() { return condicionSalud; }
    public void setCondicionSalud(String condicionSalud) { this.condicionSalud = condicionSalud; }
    public Set<CitaNeo> getCitas() { return citas; }
    public void setCitas(Set<CitaNeo> citas) { this.citas = citas; }
}
