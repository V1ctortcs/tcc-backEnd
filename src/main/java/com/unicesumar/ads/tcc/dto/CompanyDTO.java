package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.entity.TravelContractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {

    @JsonProperty("id_company")
    private Integer idCompany;

    @JsonProperty("person")
    private PersonDTO person;

    @JsonProperty("social_reason")
    private String socialReason;

    @JsonProperty("fantasy_name")
    private String fantasyName;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("state_regis")
    private String stateRegis;

    @JsonProperty("open_date")
    private LocalDate openDate;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("vehicles")
    private List<VehicleDTO> vehicles;

    @JsonProperty("travels")
    private List<TravelContractDTO> travelContracts;

}