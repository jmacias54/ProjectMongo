package com.mx.itz.mongo.entity;

import lombok.Data;

@Data
public class InformacionEscolar {

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Telefonos telefonos;
}
