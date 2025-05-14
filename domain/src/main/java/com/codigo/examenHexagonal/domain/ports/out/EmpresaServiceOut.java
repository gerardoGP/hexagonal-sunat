package com.codigo.examenHexagonal.domain.ports.out;

import com.codigo.examenHexagonal.domain.aggregates.dto.EmpresaDTO;

public interface EmpresaServiceOut {
    EmpresaDTO createEmpresaOut(String ruc);
}
