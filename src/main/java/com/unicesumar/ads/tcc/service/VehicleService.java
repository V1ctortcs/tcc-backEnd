package com.unicesumar.ads.tcc.service;

import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.data.entity.VehicleTypeEntity;
import com.unicesumar.ads.tcc.data.repository.VehicleRepository;
import com.unicesumar.ads.tcc.data.repository.VehicleTypeRepository;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleRepository vehicleRepository;

    public void postTypeVehicle(VehicleTypeEntity entity)
    {
        vehicleTypeRepository.save(entity);
    }

    public VehicleTypeEntity getVehicleTypeById(Integer id){
        return vehicleTypeRepository.getByIdVehicleType(id);
    }

    public void PostVehicle(VehicleEntity entity){
        vehicleRepository.save(entity);
    }

    public void putVehicleType(VehicleTypeEntity entity){
        vehicleTypeRepository.save(entity);
    }

    public List<VehicleEntity> getAllVehicleByActive(){
        return vehicleRepository.getByActive(true);
    }

    public List<VehicleEntity> getAllTypeVehicleByCnpj(String cnpj){
        return vehicleRepository.getByCompanyCnpjStartsWithAndActive(cnpj, true);
    }

    public List<VehicleTypeEntity> getAllVehicleType(){
        return vehicleTypeRepository.findAll();
    }

}