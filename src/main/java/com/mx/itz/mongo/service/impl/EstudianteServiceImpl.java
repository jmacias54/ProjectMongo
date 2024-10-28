package com.mx.itz.mongo.service.impl;

import com.mx.itz.mongo.dto.EstudianteDTO;
import com.mx.itz.mongo.entity.Estudiante;
import com.mx.itz.mongo.entity.InformacionEscolar;
import com.mx.itz.mongo.entity.InformacionPersonal;
import com.mx.itz.mongo.entity.Telefonos;
import com.mx.itz.mongo.repository.EstudianteRepository;
import com.mx.itz.mongo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Map> getEstudiantesAgrupadosPorCarrera() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("informacionPersonal.carrera")
                        .push("$$ROOT").as("estudiantes")
        );

        AggregationResults<Map> results = mongoTemplate.aggregate(aggregation, "estudiantes", Map.class);
        return results.getMappedResults();
    }



    @Override
    public void addEstudiante(EstudianteDTO estudianteDTO) {
        // Crear instancias de las clases internas
        InformacionPersonal informacionPersonal = new InformacionPersonal();
        informacionPersonal.setCarrera(estudianteDTO.getCarrera());
        informacionPersonal.setSemestre(estudianteDTO.getSemestre());
        informacionPersonal.setMaterias(estudianteDTO.getMaterias());

        InformacionEscolar informacionEscolar = new InformacionEscolar();
        informacionEscolar.setNombre(estudianteDTO.getNombre());
        informacionEscolar.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
        informacionEscolar.setApellidoMaterno(estudianteDTO.getApellidoMaterno());

        // Crear y guardar el estudiante
        Estudiante estudiante = new Estudiante();
        estudiante.setInformacionPersonal(informacionPersonal);
        estudiante.setInformacionEscolar(informacionEscolar);

        // Setear los teléfonos
        Telefonos telefonos = new Telefonos();
        telefonos.setCelular(estudianteDTO.getTelefonoCelular());
        telefonos.setCasa(estudianteDTO.getTelefonoCasa());
        informacionEscolar.setTelefonos(telefonos);

        estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }
}
