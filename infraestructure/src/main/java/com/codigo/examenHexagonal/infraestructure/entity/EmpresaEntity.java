package com.codigo.examenHexagonal.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numDocEmp;
    private String razSocEmp;
    private String statusEmp;
    private String conditionEmp;
    private String addresEmp;
    private String depaEmp;
    private String provEmp;
    private String distEmp;
    private String economicActivityEmp;
    private Integer numEmployedEmp;
    private String userCreateEmp;
    private Timestamp dateCreateEmp;
}