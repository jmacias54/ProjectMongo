package com.mx.itz.mongo.repository;

import com.mx.itz.mongo.entity.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
}
