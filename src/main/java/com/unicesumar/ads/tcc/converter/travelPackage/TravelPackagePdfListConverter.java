package com.unicesumar.ads.tcc.converter.travelPackage;

import com.unicesumar.ads.tcc.converter.DTOEntityConverter;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.dto.listPassengerPdfDTO.TravelPackagePdfListDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TravelPackagePdfListConverter extends DTOEntityConverter<TravelPackagePdfListDTO, TravelPackageEntity> {
    private final MapperUtil mapperUtil;

    @Override
    protected TravelPackagePdfListDTO toDTOImp(TravelPackageEntity entity) {
        return mapperUtil.use().map(entity, TravelPackagePdfListDTO.class);
    }

    @Override
    protected TravelPackageEntity toEntityImp(TravelPackagePdfListDTO dto) {
        return mapperUtil.use().map(dto, TravelPackageEntity.class);
    }
}
