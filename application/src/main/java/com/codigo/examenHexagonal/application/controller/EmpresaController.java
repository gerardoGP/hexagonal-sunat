package com.codigo.examenHexagonal.application.controller;

import com.codigo.examenHexagonal.domain.aggregates.dto.EmpresaDTO;
import com.codigo.examenHexagonal.domain.ports.in.EmpresaServiceIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sunat/")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaServiceIn serviceIn;

    @PostMapping("/save")
    public ResponseEntity<EmpresaDTO> createEmpresa(@RequestParam("ruc") String ruc){
        return ResponseEntity.ok(serviceIn.createEmpresaIn(ruc));
    }
}
