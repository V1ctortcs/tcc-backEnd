package com.unicesumar.ads.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPackgeDTO {

    @JsonProperty("id_travel_packge")
    private Integer idTravelPackge;

    @JsonProperty("name_travel_packge")
    private String nameTravelPackge;

    @JsonProperty("descr_travel_packge")
    private String descrTravelPackge;

    @JsonProperty("destination_name")
    private String destinationName;

    @JsonProperty("origin_name")
    private String originName;

    @JsonProperty("adult_price")
    private BigDecimal adultPrice;

    @JsonProperty("child_price")
    private BigDecimal childPrice;

    @JsonProperty("route")
    private String route;

    @JsonProperty("payment_methods")
    private String paymentMethods;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("expected_start_time" )
    private LocalTime expectedStartTime;

    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("estimated_end_time" )
    private LocalTime estimatedEndTime;

    @JsonProperty("feature_travel_packge")
    private String featureTravelPackge;

    @JsonProperty("registration_date")
    private LocalDate registrationDate;

    @JsonProperty("hostings_Travel_Packages")
    private List<HostingTravelPackageDTO> hostingTravelPackageEntities;

    @JsonProperty("vehicles_Travel_Packges")
    private List<VehicleTravelPackgeDTO> vehicleTravelPackgeEntities;

}