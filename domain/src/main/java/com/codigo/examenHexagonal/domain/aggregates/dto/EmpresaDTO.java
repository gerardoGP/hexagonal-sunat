package com.codigo.examenHexagonal.domain.aggregates.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
    private Long id;
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
    private String userCreatePerson;
    private Timestamp dateCreatePerson;
}
