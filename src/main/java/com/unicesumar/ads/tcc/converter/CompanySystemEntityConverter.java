package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanySystemEntityConverter extends DTOEntityConverter<CompanySystemDTO, CompanySystemEntity>{

    private final MapperUtil mapperUtil;

    @Override
    protected CompanySystemDTO toDTOImp(CompanySystemEntity entity){
        return mapperUtil.use().map(entity, CompanySystemDTO.class);
    }

    @Override
    protected CompanySystemEntity toEntityImp(CompanySystemDTO dto){
        return mapperUtil.use().map(dto, CompanySystemEntity.class);
    }

}