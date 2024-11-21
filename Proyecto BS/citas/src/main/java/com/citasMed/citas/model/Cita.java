package com.citasMed.citas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Citas")
public class Cita {
    @Id
    private String id;

    private String pacienteId;
    private String medicoId;
    private Date fecha;
    private String estado;
    private String observaciones;

    // Métodos personalizados para claridad
    public String getPaciente() {
        return pacienteId;
    }

    public void setPaciente(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getMedico() {
        return medicoId;
    }

    public void setMedico(String medicoId) {
        this.medicoId = medicoId;
    }

}
