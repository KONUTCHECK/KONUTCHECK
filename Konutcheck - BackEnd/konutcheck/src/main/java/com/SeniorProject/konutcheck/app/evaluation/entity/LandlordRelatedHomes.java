package com.SeniorProject.konutcheck.app.evaluation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LANDLORD_RELATED_HOMES")
@Getter
@Setter
public class LandlordRelatedHomes {
    @Id
    @SequenceGenerator(name = "LandlordRelatedHomes", sequenceName = "LANDLORD_RELATED_HOMES_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "LandlordRelatedHomes")
    private Long id;

    @Column(name = "LANDLORD_ID", nullable = false)
    private Long landlordId;

    @Column(name = "HOME_ID", nullable = false)
    private Long homeId;
}
