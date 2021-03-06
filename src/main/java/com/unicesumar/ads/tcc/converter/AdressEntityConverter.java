package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.AdressEntity;
import com.unicesumar.ads.tcc.dto.AdressDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdressEntityConverter extends DTOEntityConverter<AdressDTO, AdressEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected AdressDTO toDTOImp(AdressEntity entity){
        return mapperUtil.use().map(entity, AdressDTO.class);
    }

    @Override
    protected AdressEntity toEntityImp(AdressDTO dto){
        return mapperUtil.use().map(dto, AdressEntity.class);
    }

}