package com.citasMed.citas.Neo4J.repositoryNeo;

import com.citasMed.citas.Neo4J.modelNeo.PacienteNeo;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface PacienteNeoRepository extends Neo4jRepository<PacienteNeo, String> {
    @Query("#{#query}")
    void executeCustomQuery(@Param("query") String query);

    @Query(value = "#{#query}")
    List<PacienteNeo> executeCustomQueryWithParams(@Param("query") String query, @Param("params") Map<String, Object> params);

}
