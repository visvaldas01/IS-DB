package com.example.isdb.controller;

import com.example.isdb.data.Patient;
import com.example.isdb.repository.PatientRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/all")
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @PostMapping("/create")
    public Patient create(@RequestBody Patient patient) {
        patient = patientRepository.save(patient);
        return patient;
    }

    @GetMapping("/delete/{id}")
    public List<Patient> delete(@PathVariable long id) {
        patientRepository.deleteById(id);
        return patientRepository.findAll();
    }

    @PostMapping("/check")
    public List<Patient> find(@RequestBody ObjectNode params) {
        String name = params.get("name").asText();
        Long phone = params.get("phone").asLong();
        return patientRepository.findByNameAndPhone(name, phone);
    }
}
