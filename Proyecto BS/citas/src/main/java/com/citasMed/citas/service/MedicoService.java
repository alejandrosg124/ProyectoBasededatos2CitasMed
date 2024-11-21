package com.citasMed.citas.service;

import com.citasMed.citas.model.Medico;
import com.citasMed.citas.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    //Obtener todos los médicos
    public List<Medico> obtenerTodos(){
        return medicoRepository.findAll();
    }

    //Guardar un médico
    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Método para registrar un nuevo médico
    public Medico registrarMedico(Medico medico) {
        // Guarda el médico en la base de datos
        return medicoRepository.save(medico);
    }
}

