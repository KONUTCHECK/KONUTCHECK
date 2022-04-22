package com.SeniorProject.konutcheck.app.evaluation.entity;

import javax.persistence.*;

@Entity
@Table(name= "HOMES_RELATED_WITH_USERS")

public class HomesRelatedWithUsers {
    @Id
    @SequenceGenerator(name = "HomesRelatedWithUsers", sequenceName = "HOMES_RELATED_WITH_USERS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "HomesRelatedWithUsers")
    private Long id;

}
