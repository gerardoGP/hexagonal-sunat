package com.codigo.examenHexagonal.infraestructure.config;

import com.codigo.examenHexagonal.infraestructure.entity.EmpresaEntity;
import com.codigo.examenHexagonal.infraestructure.response.ResponseSunat;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper(){

        return new ModelMapper();
    }

    @Bean(name = "sunatMapper")
    public ModelMapper sunatMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.createTypeMap(ResponseSunat.class, EmpresaEntity.class)
                .addMapping(ResponseSunat::getRazonSocial, (dest,v)->dest.setRazSocEmp((String) v))
                .addMapping(ResponseSunat::getNumeroDocumento, (dest,v)->dest.setNumDocEmp((String) v))
                .addMapping(ResponseSunat::getEstado, (dest,v)->dest.setStatusEmp((String) v))
                .addMapping(ResponseSunat::getCondicion, (dest,v)->dest.setConditionEmp((String) v))
                .addMapping(ResponseSunat::getDireccion, (dest,v)->dest.setAddresEmp((String) v))
                .addMapping(ResponseSunat::getDepartamento, (dest,v)->dest.setDepaEmp((String) v))
                .addMapping(ResponseSunat::getProvincia, (dest,v)->dest.setProvEmp((String) v))
                .addMapping(ResponseSunat::getDistrito, (dest,v)->dest.setDistEmp((String) v))
                .addMapping(ResponseSunat::getActividadEconomica, (dest,v)->dest.setEconomicActivityEmp((String) v))
                .addMapping(ResponseSunat::getNumeroTrabajadores, (dest,v)->dest.setNumEmployedEmp((Integer) v));
        return mapper;
    }
}
