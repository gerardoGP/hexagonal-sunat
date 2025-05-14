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
    private String numDoc;
    private String razSoc;
    private String status;
    private String condition;
    private String addres;
    private String depa;
    private String prov;
    private String dist;
    private String economicActivity;
    private Integer numEmployed;
    private String userCreate;
    private Timestamp dateCreate;
}
