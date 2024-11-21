package com.citasMed.citas.service;

import com.citasMed.citas.model.Paciente;
import com.citasMed.citas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    //Obtener todos los pacientes
    public List<Paciente> obtenerTodos(){
        return pacienteRepository.findAll();
    }

    // Cambiar la prioridad de pacientes mayores de 65 con ciertas condiciones de salud
    public void cambiarPrioridadAlta() {
        List<Paciente> pacientes = pacienteRepository.findAll(); // Obtiene todos los pacientes
        for (Paciente paciente : pacientes) { // Itera sobre los pacientes
            if (paciente.getEdad() > 65 && 
                (paciente.getCondicionSalud().contains("Hipertensión") ||
                paciente.getCondicionSalud().contains("Diabetes") ||
                paciente.getCondicionSalud().contains("Cáncer"))) {
                paciente.setPrioridad("Alta"); // Cambia la prioridad
                pacienteRepository.save(paciente); // Guarda el cambio
            }
        }
    }

    // Consulta de pacientes por rango de edad y EPS
    public List<Paciente> consultarPorRangoEdadYeps(int edadMin, int edadMax, String eps) {
        // Filtra pacientes con las condiciones dadas
        return pacienteRepository.findByEdadBetweenAndEps(edadMin, edadMax, eps);
    }

    // Consulta de pacientes mayores de 65 años por EPS
    public List<Paciente> consultarMayores65PorEps(String eps) {
        // Filtra pacientes mayores de 65 por EPS
        return pacienteRepository.findByEdadGreaterThanAndEps(65, eps);
    }

    // Actualizar un paciente por su ID
    public Paciente actualizarPaciente(String id, Paciente paciente) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado")); // Manejo de error si no existe
        pacienteExistente.setNombre(paciente.getNombre());
        pacienteExistente.setEdad(paciente.getEdad());
        pacienteExistente.setEps(paciente.getEps());
        pacienteExistente.setCondicionSalud(paciente.getCondicionSalud());
        pacienteExistente.setPrioridad(paciente.getPrioridad());
        return pacienteRepository.save(pacienteExistente); // Guarda cambios
    }

    // Registrar un nuevo paciente
    public Paciente registrarPaciente(Paciente paciente) {
        // Guarda un nuevo paciente
        return pacienteRepository.save(paciente);
    }

    // Eliminar un paciente por su ID
    public void eliminarPaciente(String id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente no encontrado");
        }
        pacienteRepository.deleteById(id);
    }
}

