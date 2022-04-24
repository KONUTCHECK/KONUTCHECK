package com.SeniorProject.konutcheck.app.evaluation.entity;

import com.SeniorProject.konutcheck.app.user.enums.UserType;

import javax.persistence.*;

@Entity
@Table(name= "HOMES_RELATED_WITH_USERS")

public class HomesRelatedWithUsers {
    @Id
    @SequenceGenerator(name = "HomesRelatedWithUsers", sequenceName = "HOMES_RELATED_WITH_USERS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "HomesRelatedWithUsers")
    private Long id;

    @Column(name="US_USER_ID", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30, nullable = false)
    private UserType userType;


    @Column(name="GENERAL_HOME_INFO_ID", nullable = false)
    private Long homeId;
}
