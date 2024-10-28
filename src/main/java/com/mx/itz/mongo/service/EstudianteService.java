package com.mx.itz.mongo.service;

import com.mx.itz.mongo.dto.EstudianteDTO;
import com.mx.itz.mongo.entity.Estudiante;

import java.util.List;
import java.util.Map;

public interface EstudianteService {

    void addEstudiante(EstudianteDTO estudianteDTO);
    List<Estudiante> getAllEstudiantes();
    List<Map> getEstudiantesAgrupadosPorCarrera();
}
