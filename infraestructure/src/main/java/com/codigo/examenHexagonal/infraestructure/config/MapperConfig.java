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
                .addMapping(ResponseSunat::getNumeroDocumento, (dest,v)->dest.setNumDoc((String) v))
                .addMapping(ResponseSunat::getRazonSocial, (dest,v)->dest.setRazSoc((String) v))
                .addMapping(ResponseSunat::getEstado, (dest,v)->dest.setStatus((String) v))
                .addMapping(ResponseSunat::getCondicion, (dest,v)->dest.setCondition((String) v))
                .addMapping(ResponseSunat::getDireccion, (dest,v)->dest.setAddres((String) v))
                .addMapping(ResponseSunat::getDepartamento, (dest,v)->dest.setDepa((String) v))
                .addMapping(ResponseSunat::getProvincia, (dest,v)->dest.setProv((String) v))
                .addMapping(ResponseSunat::getDistrito, (dest,v)->dest.setDist((String) v))
                .addMapping(ResponseSunat::getActividadEconomica, (dest,v)->dest.setEconomicActivity((String) v))
                .addMapping(ResponseSunat::getNumeroTrabajadores, (dest,v)->dest.setNumEmployed((String) v));
        return mapper;
    }
}
