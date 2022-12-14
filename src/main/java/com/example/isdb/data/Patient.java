package com.example.isdb.data;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "patients", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "phone"}))
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "addresses_id")
    Address address;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "phone")
    Long phone;

    @Column(name = "birthdate", nullable = false)
    LocalDate birthdate;
}
