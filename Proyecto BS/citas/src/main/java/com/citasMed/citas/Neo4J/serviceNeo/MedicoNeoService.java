package com.citasMed.citas.Neo4J.serviceNeo;

import com.citasMed.citas.Neo4J.modelNeo.MedicoNeo;
import com.citasMed.citas.Neo4J.repositoryNeo.MedicoNeoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedicoNeoService {

    private final MedicoNeoRepository medicoNeoRepository;

    public MedicoNeoService(MedicoNeoRepository medicoNeoRepository) {
        this.medicoNeoRepository = medicoNeoRepository;
    }

    public MedicoNeo registrarMedico(MedicoNeo medico) {
        return medicoNeoRepository.save(medico);
    }
}
