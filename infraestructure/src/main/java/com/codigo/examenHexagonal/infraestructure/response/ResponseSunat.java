package com.codigo.examenHexagonal.infraestructure.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSunat {
    private String razonSocial;
    private String numeroDocumento;
    private String estado;
    private String condicion;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String actividadEconomica;
    private Integer numeroTrabajadores;
}
