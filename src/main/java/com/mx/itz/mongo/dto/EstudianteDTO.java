package com.mx.itz.mongo.dto;

import lombok.Data;

import java.util.List;

@Data
public class EstudianteDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String carrera;
    private String semestre;
    private List<String> materias;
    private String telefonoCelular;
    private String telefonoCasa;
}