package com.unicesumar.ads.tcc.dto.personDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicesumar.ads.tcc.dto.AdressDTO;
import com.unicesumar.ads.tcc.dto.BankDetailsDTO;
import com.unicesumar.ads.tcc.dto.CompanyDTO;
import com.unicesumar.ads.tcc.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonCompanyDTO {

    private CompanyDTO company;

    private List<ContactDTO> contacts;

    private List<AdressDTO> adresses;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("banks_details")
    private List<BankDetailsDTO> banksDetails;

}
