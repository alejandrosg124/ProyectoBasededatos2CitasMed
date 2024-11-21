package com.citasMed.citas.repository;

import com.citasMed.citas.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String>{
    // Método personalizado: Buscar pacientes mayores de cierta edad y con condiciones específicas
    List<Paciente> findByEdadGreaterThanAndCondicionSaludIn(int edad, List<String> condicionSalud);

    // Método personalizado: Buscar pacientes dentro de un rango de edad inscritos en una EPS específica
    List<Paciente> findByEdadBetweenAndEps(int edadMin, int edadMax, String eps);

    // Método personalizado: Buscar pacientes mayores de cierta edad en una EPS específica
    List<Paciente> findByEdadGreaterThanAndEps(int edad, String eps);
}