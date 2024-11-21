package com.citasMed.citas.Neo4J.repositoryNeo;

import com.citasMed.citas.Neo4J.modelNeo.CitaNeo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import org.springframework.data.repository.query.Param;
import java.util.Map;


public interface CitaNeoRepository extends Neo4jRepository<CitaNeo, String> {
@Query("#{#query}")
    void executeCustomQuery(@Param("query") String query);

    @Query("#{#query}")
    void executeCustomQueryWithParams(@Param("query") String query, @Param("params") Map<String, Object> params);
}
