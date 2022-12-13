package com.example.isdb.data;

import jakarta.persistence.*;

@Entity
@Table(name = "work")
public class Work {

    @EmbeddedId
    WorkPK id;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name = "doctors_id")
    Doctor doctor;

    @ManyToOne
    @MapsId("clinicId")
    @JoinColumn(name = "clinics_id")
    Clinic clinic;
}
