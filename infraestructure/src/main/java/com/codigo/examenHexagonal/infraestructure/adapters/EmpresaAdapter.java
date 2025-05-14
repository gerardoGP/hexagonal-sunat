package com.codigo.examenHexagonal.infraestructure.adapters;

import com.codigo.examenHexagonal.domain.aggregates.dto.EmpresaDTO;
import com.codigo.examenHexagonal.domain.ports.out.EmpresaServiceOut;
import com.codigo.examenHexagonal.infraestructure.entity.EmpresaEntity;
import com.codigo.examenHexagonal.infraestructure.repository.EmpresaRepository;
import com.codigo.examenHexagonal.infraestructure.response.ResponseSunat;
import com.codigo.examenHexagonal.infraestructure.rest.SunatClient;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@Log4j2
public class EmpresaAdapter implements EmpresaServiceOut {

    private final SunatClient sunatClient;
    private final ModelMapper empresaMapper;
    private final ModelMapper sunatMapper;
    private final EmpresaRepository empresaRepository;
    @Value("${token.api}")
    private String token;

    public EmpresaAdapter(SunatClient sunatClient,
                          @Qualifier("defaultMapper") ModelMapper empresaMapper,
                          @Qualifier("sunatMapper") ModelMapper sunatMapper,
                          EmpresaRepository empresaRepository) {
        this.sunatClient = sunatClient;
        this.empresaMapper = empresaMapper;
        this.sunatMapper = sunatMapper;
        this.empresaRepository = empresaRepository;
    }

    @Override
    public EmpresaDTO createEmpresaOut(String ruc) {
        EmpresaEntity empresa = getEntityForSave(ruc);
        EmpresaEntity empresaEntity = empresaRepository.save(empresa);
        EmpresaDTO dto = mapToEmpresaDTO(empresaEntity);
        return dto;
    }

    private EmpresaEntity getEntityForSave(String ruc){
        log.info("{} - {} INICIO, getEntityForSave to: ",ruc);
        ResponseSunat responseSunat = executeSunat(ruc);
        if (responseSunat == null || responseSunat.getNumeroDocumento() == null) {
            throw new RuntimeException("Respuesta invalida de SUNAT: "+ruc);
        }
        EmpresaEntity empresa = mapSunatToEmpresaEntity(responseSunat);
        empresa.setUserCreate("GGARIBAY");
        empresa.setDateCreate(new Timestamp(System.currentTimeMillis()));
        return empresa;
    }
    private ResponseSunat executeSunat(String ruc){
        log.info("Consultando los datos a SUNAT para el RUC "+ruc);
        String header = "Bearer "+token;
        return Optional.ofNullable(sunatClient.getInfoSunat(ruc,header))
                .orElseThrow(() -> new RuntimeException("Error al consultar con SUNAT"));
    }
    private EmpresaDTO mapToEmpresaDTO(EmpresaEntity empresaEntity){
        return empresaMapper.map(empresaEntity, EmpresaDTO.class);
    }
    private EmpresaEntity mapSunatToEmpresaEntity(ResponseSunat responseSunat){
        return sunatMapper.map(responseSunat, EmpresaEntity.class);
    }
}
