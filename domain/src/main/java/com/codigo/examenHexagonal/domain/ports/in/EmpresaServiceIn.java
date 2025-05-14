package com.codigo.examenHexagonal.domain.ports.in;

import com.codigo.examenHexagonal.domain.aggregates.dto.EmpresaDTO;

public interface EmpresaServiceIn {
    EmpresaDTO createEmpresaIn(String ruc);
}
