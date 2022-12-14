package com.example.isdb.data;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "specialities_id", nullable = false)
    Speciality speciality;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "experience", nullable = false)
    Integer experience;
}
