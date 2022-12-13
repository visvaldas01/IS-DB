package com.example.isdb.data.PK;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PointsPK implements Serializable {
    @Column(name = "symptoms_id")
    Long symptomId;

    @Column(name = "specialities_id")
    Long specialityId;
}