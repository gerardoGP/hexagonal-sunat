package com.codigo.examenHexagonal.infraestructure.repository;

import com.codigo.examenHexagonal.infraestructure.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
