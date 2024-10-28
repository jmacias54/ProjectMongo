package com.mx.itz.mongo.entity;

import lombok.Data;

import java.util.List;

@Data
public class InformacionPersonal {

    private String carrera;
    private String semestre;
    private List<String> materias;

}
