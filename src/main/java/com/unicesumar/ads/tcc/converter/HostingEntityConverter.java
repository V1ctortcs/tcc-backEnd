package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.dto.HostingDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HostingEntityConverter extends DTOEntityConverter<HostingDTO, HostingEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected com.unicesumar.ads.tcc.dto.HostingDTO toDTOImp(HostingEntity entity){
        return mapperUtil.use().map(entity, com.unicesumar.ads.tcc.dto.HostingDTO.class);
    }

    @Override
    protected HostingEntity toEntityImp(com.unicesumar.ads.tcc.dto.HostingDTO dto){
        return mapperUtil.use().map(dto, HostingEntity.class);
    }

}