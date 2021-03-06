package com.unicesumar.ads.tcc.dto.vehiclePutDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.VehicleTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiclePutDTO {

    @JsonProperty("id_vehicle")
    private Integer idVehicle;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cnpj")
    private String cnpj;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_vehicle_type")
    private Integer idVehicleType;

    @JsonIgnore
    private CompanyPutDTO company;

    @JsonIgnore
    private VehicleTypeDTO vehicleType;

    @JsonProperty("rntrc")
    private String rntrc;

    @JsonProperty("active")
    private Boolean active;

}