package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdressDTO {

    @JsonProperty("id_adress")
    private Integer idAdress;

    @JsonProperty("person")
    private PersonDTO person;

    @JsonProperty("adress")
    private String adress;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("additional")
    private String additional;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("zip_code")
    private String zipCode;

}