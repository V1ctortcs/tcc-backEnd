package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.TravelPackageEntityConverter;
import com.unicesumar.ads.tcc.converter.hosting.HostingPutEntityConverter;
import com.unicesumar.ads.tcc.converter.travelPackage.TravelPackageGetEntityConverter;
import com.unicesumar.ads.tcc.converter.travelPackage.TravelPackagePostEntityConverter;
import com.unicesumar.ads.tcc.converter.vehicle.VehicleGetEntityConverter;
import com.unicesumar.ads.tcc.data.entity.HostingEntity;
import com.unicesumar.ads.tcc.data.entity.TravelPackageEntity;
import com.unicesumar.ads.tcc.data.entity.VehicleEntity;
import com.unicesumar.ads.tcc.dto.TravelPackageDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingPutDTO;
import com.unicesumar.ads.tcc.dto.travelPackagePostDTO.TravelPackageGetDTO;
import com.unicesumar.ads.tcc.dto.travelPackagePostDTO.TravelPackagePostDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.HostingService;
import com.unicesumar.ads.tcc.service.TravelPackageService;
import com.unicesumar.ads.tcc.service.VehicleService;
import com.unicesumar.ads.tcc.util.PaginatorUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of Travel Package"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ADMIN')")
public class TravelPackageController {

    /**
     * Services
     */
    private final TravelPackageService travelPackageService;
    private final HostingService hostingService;
    private final VehicleService vehicleService;

    /**
     * Converters
     */
    private final TravelPackageEntityConverter travelPackageEntityConverter;
    private final TravelPackagePostEntityConverter travelPackagePostEntityConverter;
    private final TravelPackageGetEntityConverter travelPackageGetEntityConverter;
    private final HostingPutEntityConverter hostingPutEntityConverter;
    private final VehicleGetEntityConverter vehicleGetEntityConverter;

    /**
     * Utils
     */
    private final PaginatorUtil paginator;

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to return all travelpackage",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelpackage/all")
    public ResponseEntity<List<TravelPackageDTO>> getTravelPackageAll() {
        List<TravelPackageEntity> entities = new ArrayList<>();
        entities = travelPackageService.getTravelPackage();
        List<TravelPackageDTO> dtos = travelPackageEntityConverter.toDTOList(entities);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to return by codigo, nome, local origem, local destino, or return all travelpackage",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelpackage/filter")
    public ResponseEntity<Page<TravelPackageDTO>> getTravelPackageFilter(Pageable pageable,
                                                                         @RequestParam(value = "idtravelpackge",
                                                                                 required = false)
                                                                                 Integer idTravelPackge,
                                                                         @RequestParam(value = "nametravelpackge",
                                                                                 required = false)
                                                                                 Optional<String> nameTravelPackage,
                                                                         @RequestParam(value = "originname",
                                                                                 required = false)
                                                                                     Optional<String> originName,
                                                                         @RequestParam(value = "destinationName",
                                                                                 required = false)
                                                                                     Optional<String> destinationName,
                                                                         @RequestParam(value = "active",
                                                                                 defaultValue = "true",
                                                                                 required = false)
                                                                                     Boolean active) {
        Page<TravelPackageDTO> dtos = paginator.convertDTOTravelPackageToPages(idTravelPackge, nameTravelPackage,
                originName, destinationName, active, pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ApiOperation(value = "URL to return by idtravelpackge travelpackage",
            authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/travelpackage/id")
    public ResponseEntity<TravelPackageGetDTO> getTravelPackageById(@RequestParam(value = "idtravelpackge",
                                                                                required = false)
                                                                                Integer idTravelPackge) {
        TravelPackageEntity entity = travelPackageService.getTravelPackageById(idTravelPackge);
        if(entity != null) {
            TravelPackageGetDTO dto = travelPackageGetEntityConverter.toDTO(entity);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpNotFoundException(NENHUM_PACOTE_DE_VIAGEM_LOCALIZADO);
    }

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to add travel package", authorizations = {@Authorization(value="jwtToken")})
    @PostMapping(path = "/travelpackage")
    public ResponseEntity<TravelPackagePostDTO> postTravelPackage(@Validated @RequestBody TravelPackagePostDTO dto){
        if (dto != null){
            dto.setHostings(new ArrayList<>());
            dto.setVehicles(new ArrayList<>());
            for  (Integer id : dto.getIdsHost() ){
                HostingEntity hosting = hostingService.getHostingById(id);
                if (hosting != null) {

                    dto.getHostings().add(hostingPutEntityConverter.toDTO(hosting));
                }
                else{
                    throw new HttpNotFoundException(HOSPEDAGEM_NAO_ENCONTRADO);
                }
            }
            for  (Integer id : dto.getIdsVehi() ){
                VehicleEntity vehicle = vehicleService.getVehicleById(id);
                if (vehicle != null){

                    dto.getVehicles().add(vehicleGetEntityConverter.toDTO(vehicle));
                }
                else{
                    throw new HttpNotFoundException(VEICULO_NAO_ENCONTRADO);
                }
            }
            travelPackageService.postTravelPackage(travelPackagePostEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(NENHUM_PACOTE_DE_VIAGEM_LOCALIZADO);
    }

    /**
     * PutsMapping
     */
    @ApiOperation(value = "URL to update travel package", authorizations = {@Authorization(value="jwtToken")})
    @PutMapping(path = "/travelpackage")
    public ResponseEntity<TravelPackageDTO> postTravelPackage(@Validated @RequestBody TravelPackageDTO dto){
        if (dto != null){
            dto.setHostings(new ArrayList<>());
            dto.setVehicles(new ArrayList<>());
            for  (Integer id : dto.getIdsHost() ){
                HostingEntity hosting = hostingService.getHostingById(id);
                if (hosting != null) {

                    dto.getHostings().add(hostingPutEntityConverter.toDTO(hosting));
                }
                else{
                    throw new HttpNotFoundException(HOSPEDAGEM_NAO_ENCONTRADO);
                }
            }
            for  (Integer id : dto.getIdsVehi() ){
                VehicleEntity vehicle = vehicleService.getVehicleById(id);
                if (vehicle != null){

                    dto.getVehicles().add(vehicleGetEntityConverter.toDTO(vehicle));
                }
                else{
                    throw new HttpNotFoundException(VEICULO_NAO_ENCONTRADO);
                }
            }
            travelPackageService.postTravelPackage(travelPackageEntityConverter.toEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(NENHUM_PACOTE_DE_VIAGEM_LOCALIZADO);
    }

}
