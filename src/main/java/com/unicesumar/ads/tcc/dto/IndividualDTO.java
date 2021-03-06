package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.personGetDTO.AdressGetDTO;
import com.unicesumar.ads.tcc.dto.personGetDTO.ContactGetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndividualDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_individual")
    private Integer idIndividual;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean active;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("name_individual")
    private String nameIndividual;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("contact")
    private ContactGetDTO contact;

}