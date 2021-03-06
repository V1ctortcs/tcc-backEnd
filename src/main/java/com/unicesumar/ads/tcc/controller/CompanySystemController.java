package com.unicesumar.ads.tcc.controller;

import com.unicesumar.ads.tcc.converter.CompanySystemGetAllEntityConverter;
import com.unicesumar.ads.tcc.converter.companyPartner.CompanyPartnerEntityGetConverter;
import com.unicesumar.ads.tcc.data.entity.CompanyPartnerEntity;
import com.unicesumar.ads.tcc.data.entity.CompanySystemEntity;
import com.unicesumar.ads.tcc.data.entity.PersonEntity;
import com.unicesumar.ads.tcc.dto.CompanyPartnerDTO;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanyPartnerGetDTO;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemDTO;
import com.unicesumar.ads.tcc.dto.companyDTO.CompanySystemGetAllDTO;
import com.unicesumar.ads.tcc.exception.HttpBadRequestException;
import com.unicesumar.ads.tcc.exception.HttpNotFoundException;
import com.unicesumar.ads.tcc.service.CompanyPartnerService;
import com.unicesumar.ads.tcc.service.CompanySystemService;
import com.unicesumar.ads.tcc.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.unicesumar.ads.tcc.controller.constants.ControllerConstants.*;

@Api(tags = {"visualization of CompanySystem"})
@RestController
@RequestMapping(value = "api")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CompanySystemController {

    /**
     * Services
     */
    private final CompanySystemService companySystemService;
    private final CompanyPartnerService companyPartnerService;
    private final PersonService personService;

    /**
     * Converters
     */
    private final CompanyPartnerEntityGetConverter companyPartnerEntityConverter;
    private final CompanySystemGetAllEntityConverter companySystemGetAllEntityConverter;


    /**
     * GetsMapping
     */
    @ApiOperation(value = "URL to get all Company Partner", authorizations = {@Authorization(value="jwtToken")})
    @GetMapping(path = "/companyPartner")
    public ResponseEntity<List<CompanyPartnerGetDTO>> getCompanyPartner(Pageable pageable,
                                                                        @RequestParam(value = "cnpj") String cnpj) {
        List<CompanyPartnerEntity> entities = companyPartnerService.getCompanyPartners(cnpj);
        if (entities != null){
            List<CompanyPartnerGetDTO> dtos = new ArrayList<>();
            for (CompanyPartnerEntity entity : entities ){
                dtos.add(companyPartnerEntityConverter.toDTO(entity.getIndividual()));
            }
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException(PESSOA_NAO_LOCALIZADA);
    }

    @ApiOperation(value = "URL to Return All Company", authorizations = { @Authorization(value="jwtToken")})
    @GetMapping(path = "/companySystem")
    public ResponseEntity<List<CompanySystemGetAllDTO>> getCompanySystem() {

        List<CompanySystemEntity> entities = companySystemService.getAllCompanySystem();
        if(entities.size() != 0) {
            List<CompanySystemGetAllDTO> dtos = new ArrayList<>();
            for (CompanySystemEntity company : entities){
                CompanySystemGetAllDTO dto = new CompanySystemGetAllDTO();
                dto.setIdCompanySystem(company.getIdCompanySystem());
                dto.setSocialReason(company.getCompany().getSocialReason());
                dto.setFantasyName(company.getCompany().getFantasyName());
                dto.setCnpj(company.getCompany().getCnpj());
                dto.setActive(company.getActive());
                dto.setOpenDate(company.getCompany().getOpenDate());
                dtos.add(dto);
            }
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
        throw new HttpNotFoundException(EMPRESA_DO_SISTEMA_NAO_LOCALIZADA);
    }

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to add Company System", authorizations = {@Authorization(value="jwtToken")})
    @PostMapping(path = "/companySystem")
    public ResponseEntity<CompanySystemDTO> PostCompanySystem(@Validated @RequestBody CompanySystemDTO dto) {
        PersonEntity entity = personService.getPersonByCnpj(dto.getCnpj());
        if( entity != null){
            CompanySystemEntity companySystem = new CompanySystemEntity();
            companySystem.setCompany(entity.getCompany());
            companySystemService.postCompanySystem(companySystem);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(PESSOA_NAO_LOCALIZADA);
    }

    /**
     * PutsMapping
     */
    @ApiOperation(value = "URL to add Company System", authorizations = {@Authorization(value="jwtToken")})
    @PutMapping(path = "/companySystem")
    public ResponseEntity<CompanySystemDTO> PutCompanySystem(@Validated @RequestBody CompanySystemDTO dto) {
        CompanySystemEntity entity = companySystemService.getCompanySystemByCnpj(dto.getCnpj());
        if (entity != null){
            entity.setActive(dto.getActive());
            companySystemService.postCompanySystem(entity);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(NENHUMA_EMPRESA_LOCALIZADA);
    }

    /**
     * PostsMapping
     */
    @ApiOperation(value = "URL to add Company Partner", authorizations = {@Authorization(value="jwtToken")})
    @PostMapping(path = "/companyPartner")
    public ResponseEntity<CompanyPartnerDTO> PostCompanyPartner(@Validated @RequestBody CompanyPartnerDTO dto) {
        PersonEntity entity = personService.getPersonByCpf(dto.getCpf());
        CompanySystemEntity entityCompanySystem = companySystemService.getCompanySystemByCnpj(dto.getCnpj());
        if( entity != null && entityCompanySystem != null){
            CompanyPartnerEntity companyPartner = new CompanyPartnerEntity();
            companyPartner.setCompanySystem(entityCompanySystem);
            companyPartner.setIndividual(entity.getIndividual());
            companyPartner.setActive(true);
            companyPartnerService.postCompanyPartner(companyPartner);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        throw new HttpBadRequestException(PESSOA_NAO_LOCALIZADA);
    }

    /**
     * PutsMapping
     */
    @ApiOperation(value = "URL to update Company Partner", authorizations = {@Authorization(value="jwtToken")})
    @PutMapping(path = "/companyPartner")
    public ResponseEntity<CompanyPartnerDTO> PutCompanyPartner(@RequestParam(value = "cpf") String cpf){
        CompanyPartnerEntity entity = companyPartnerService.getCompanyPartnerByCpfIndividual(cpf);
        if (entity != null){
            entity.setActive(false);
            companyPartnerService.postCompanyPartner(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            throw new HttpNotFoundException(PESSOA_NAO_LOCALIZADA);
        }
    }
}
