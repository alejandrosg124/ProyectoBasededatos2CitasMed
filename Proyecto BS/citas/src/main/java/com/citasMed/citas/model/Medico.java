package com.citasMed.citas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Medicos")
public class Medico {
    @Id
    private String id;
    
    private String nombre;
    private String especialidad;
}
