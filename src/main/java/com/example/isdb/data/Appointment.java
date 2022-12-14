package com.example.isdb.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "appointments", uniqueConstraints = @UniqueConstraint(columnNames = {"doctors_id", "clinics_id", "date"}))
@Check(constraints = "status_id = 1 and patients_id IS NULL and at_home IS NULL or status_id = 2 and patients_id IS NOT NULL and at_home IS NOT NULL")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "doctors_id", referencedColumnName = "doctors_id"), @JoinColumn(name = "clinics_id", referencedColumnName = "clinics_id")})
    Work work;

    @ManyToOne
    @JoinColumn(name = "patients_id")
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    Status status;

    @Column(name = "date", nullable = false)
    LocalDateTime date;

    @Column(name = "at_home")
    Boolean atHome;
}
