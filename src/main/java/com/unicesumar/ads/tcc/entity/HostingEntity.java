package com.unicesumar.ads.tcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOSTING")
public class HostingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HOSTING")
    private Integer idHosting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSON")
    private PersonEntity person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HOSTING_TYPE")
    private HostingTypeEntity hostingType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADRESS")
    private AdressEntity adress;

    @Column(name = "TOURISM_REGIS")
    private String tourismRegis;

    @Column(name = "QUANTITY_PERSON")
    private Integer quantityPerson;

    @Column(name = "FEATURES_HOSTING")
    private Integer featuresHosting;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hostingEntities")
    private List<TravelPackageEntity> travelPackages;

}
