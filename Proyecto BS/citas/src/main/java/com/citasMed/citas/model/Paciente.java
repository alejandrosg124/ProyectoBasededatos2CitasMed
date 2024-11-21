package com.citasMed.citas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Pacientes")
public class Paciente {
    @Id
    private String id;

    private String nombre;
    private int edad;
    private String genero;
    private String eps;
    private String prioridad;
    private String condicionSalud;
}
