package com.brainiacs.hospitalBackend.controller;

import com.brainiacs.hospitalBackend.model.Patient;
import com.brainiacs.hospitalBackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public boolean signup(@RequestBody Patient patient){
        try {
            patientService.save(patient);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
