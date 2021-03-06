package com.unicesumar.ads.tcc.dto.hostingPostDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.AdressDTO;
import com.unicesumar.ads.tcc.dto.hostingPutDTO.HostingTypePutDTO;
import com.unicesumar.ads.tcc.dto.personDTO.PersonCompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HostingPostDTO {

    @JsonProperty("document")
    private String cnpj;

    @JsonIgnore
    private PersonPostDTO person;

    @JsonProperty("adress")
    private AdressDTO adress;

    @JsonProperty("hosting_type")
    private HostingTypePutDTO hostingType;

    @JsonProperty("tourism_regis")
    private String tourismRegis;

    @JsonProperty("quantity_person")
    private Integer quantityPerson;

    @JsonProperty("features_hosting")
    private String featuresHosting;

    private Boolean active;
}