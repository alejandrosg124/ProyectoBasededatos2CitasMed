package com.citasMed.citas.repository;

import com.citasMed.citas.model.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends MongoRepository<Cita, String> {

    //Metodo para obtener todas las citas
    List<Cita> findAll();

    //Método buscar citas por el estado.
    List<Cita> findByEstado(String estado);

    //Metodo buscar citas por el paciente.
    List<Cita> findByPacienteId(String pacienteId);

    //Método buscar citas de un médico específico.
    List<Cita> findByMedicoId(String medicoId);

    //Método guardar citas
    Cita save(Cita cita);

    //Método eliminar cita por id.
    void deleteById(String id);

}
