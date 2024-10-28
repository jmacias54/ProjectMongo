package com.mx.itz.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;
    private InformacionPersonal informacionPersonal;
    private InformacionEscolar informacionEscolar;
}
