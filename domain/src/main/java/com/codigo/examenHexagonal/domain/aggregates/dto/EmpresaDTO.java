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
    private String razSocEmp;
    private String numDocEmp;
    private String statusEmp;
    private String conditionEmp;
    private String addresEmp;
    private String depaEmp;
    private String provEmp;
    private String distEmp;
    private String economicActivityEmp;
    private String numEmployedEmp;
    private String userCreateEmp;
    private Timestamp dateCreateEmp;
}
