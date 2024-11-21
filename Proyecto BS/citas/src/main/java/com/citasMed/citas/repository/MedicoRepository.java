package com.citasMed.citas.repository;

import com.citasMed.citas.model.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {
    
}
