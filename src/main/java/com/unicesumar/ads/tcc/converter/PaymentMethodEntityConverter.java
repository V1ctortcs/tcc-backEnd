package com.unicesumar.ads.tcc.converter;

import com.unicesumar.ads.tcc.data.entity.PaymentMethodEntity;
import com.unicesumar.ads.tcc.dto.PaymentMethodDTO;
import com.unicesumar.ads.tcc.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMethodEntityConverter extends DTOEntityConverter<PaymentMethodDTO, PaymentMethodEntity> {

    private final MapperUtil mapperUtil;

    @Override
    protected PaymentMethodDTO toDTOImp(PaymentMethodEntity entity){
        return mapperUtil.use().map(entity, PaymentMethodDTO.class);
    }

    @Override
    protected PaymentMethodEntity toEntityImp(PaymentMethodDTO dto){
        return mapperUtil.use().map(dto, PaymentMethodEntity.class);
    }

}