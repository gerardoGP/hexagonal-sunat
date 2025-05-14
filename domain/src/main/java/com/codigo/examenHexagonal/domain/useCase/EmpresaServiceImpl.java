package com.codigo.examenHexagonal.domain.useCase;


import com.codigo.examenHexagonal.domain.aggregates.dto.EmpresaDTO;
import com.codigo.examenHexagonal.domain.ports.in.EmpresaServiceIn;
import com.codigo.examenHexagonal.domain.ports.out.EmpresaServiceOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmpresaServiceImpl implements EmpresaServiceIn {
    private final EmpresaServiceOut empresaServiceOut;
    private String SERVICE_NAME = "EmpresaServiceImpl";

    @Override
    public EmpresaDTO createEmpresaIn(String ruc) {
        String nameMethod = "createEmpresaIn";
        log.info("{} - {} - INICIO",SERVICE_NAME,nameMethod);
        EmpresaDTO empresaDTO = empresaServiceOut.createEmpresaOut(ruc);
        log.info("{} - {} - FIN",SERVICE_NAME, nameMethod);
        return empresaDTO;
    }
}
