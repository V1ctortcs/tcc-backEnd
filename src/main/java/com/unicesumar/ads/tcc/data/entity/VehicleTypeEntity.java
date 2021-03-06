package com.unicesumar.ads.tcc.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VEHICLE_TYPE")
public class VehicleTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEHICLE_TYPE")
    private Integer idVehicleType;

    @Column(name = "NAME_VEHICLE_TYPE")
    private String nameVehicleType;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "NUM_SEATS")
    private Integer numSeats;

    @Column(name = "SEATS_TYPE")
    private String seatsType;

    @Column(name = "BATHROOM")
    private Boolean bathroom;

    @Column(name = "ACCESSIBILITY")
    private Boolean accessibility;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleType", cascade=CascadeType.ALL)
    private List<VehicleEntity> vehicles;

}
