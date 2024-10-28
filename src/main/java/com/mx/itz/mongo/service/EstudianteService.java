package com.mx.itz.mongo.service;

import com.mx.itz.mongo.dto.EstudianteDTO;
import com.mx.itz.mongo.entity.Estudiante;

import java.util.List;

public interface EstudianteService {

    void addEstudiante(EstudianteDTO estudianteDTO);
    List<Estudiante> getAllEstudiantes();
}
