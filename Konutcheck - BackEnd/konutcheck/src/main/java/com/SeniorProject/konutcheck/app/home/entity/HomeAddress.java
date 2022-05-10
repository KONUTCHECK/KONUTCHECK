package com.SeniorProject.konutcheck.app.home.entity;

import javax.persistence.*;

@Entity
@Table(name = "HOME_ADDRESS")
public class HomeAddress {
    @Id
    @SequenceGenerator(name = "HomeAddress", sequenceName = "HOME_ADDRESS_ID_SEQ", allocationSize = 1)
    private Long id;
}
