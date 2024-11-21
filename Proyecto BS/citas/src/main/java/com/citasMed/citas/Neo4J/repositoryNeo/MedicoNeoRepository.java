package com.citasMed.citas.Neo4J.repositoryNeo;

import com.citasMed.citas.Neo4J.modelNeo.MedicoNeo;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MedicoNeoRepository extends Neo4jRepository<MedicoNeo, String> {
   
    @Query("#{query}")
    void executeCustomQuery(String query);

}
