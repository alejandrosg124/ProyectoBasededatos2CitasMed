package com.citasMed.citas.service;

import com.citasMed.citas.model.Cita;
import com.citasMed.citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    //Obtener todas las citas
    public List<Cita> obtenerTodas() {
        return citaRepository.findAll();
    }

    //Para registrar una nueva cita médica
    public Cita registrarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    //Para actualizar una cita por ID
    public Cita actualizarCita(String id, Cita cita) {
        Cita citaExistente = citaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró la cita con el ID: " + id));
        citaExistente.setPaciente(cita.getPacienteId());
        citaExistente.setMedico(cita.getMedicoId());
        citaExistente.setFecha(cita.getFecha());
        citaExistente.setEstado(cita.getEstado());
        citaExistente.setObservaciones(cita.getObservaciones());
        return citaRepository.save(citaExistente);
    }

    // Método para eliminar una cita por ID
    public void eliminarCita(String id) {
        // Elimina la cita directamente si existe
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada");
        }
        citaRepository.deleteById(id);
    }

}
