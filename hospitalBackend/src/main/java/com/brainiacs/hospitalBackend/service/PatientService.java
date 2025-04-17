package com.brainiacs.hospitalBackend.service;

import com.brainiacs.hospitalBackend.model.Patient;
import com.brainiacs.hospitalBackend.reposotory.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void save(Patient patient){
        patientRepository.save(patient);
    }

}
