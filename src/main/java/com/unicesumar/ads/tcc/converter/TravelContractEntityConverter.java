package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.TravelContractEntity;
import com.unicesumar.ads.tcc.dto.TravelContractDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelContractEntityConverter extends DTOEntityConverter<TravelContractDTO, TravelContractEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected TravelContractDTO toDTOImp(TravelContractEntity entity){
        return mapperUtil.use().map(entity, TravelContractDTO.class);
    }
    @Override
    protected TravelContractEntity toEntityImp(TravelContractDTO dto){
        return mapperUtil.use().map(dto, TravelContractEntity.class);
    }

}