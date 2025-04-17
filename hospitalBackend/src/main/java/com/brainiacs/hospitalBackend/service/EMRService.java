package com.brainiacs.hospitalBackend.service;

import com.brainiacs.hospitalBackend.model.EMR;
import com.brainiacs.hospitalBackend.reposotory.EMRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EMRService {

    private EMRRepository emrRepository;

    @Autowired
    public EMRService(EMRRepository emrRepository) {
        this.emrRepository = emrRepository;
    }

    public List<EMR> getByPatientId(String patientId) {
        try {
            return emrRepository.findByPatientId(patientId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve EMRs for patientId: " + patientId, e);
        }
    }

    public EMR save(EMR emr) {
        try {
            return emrRepository.save(emr);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save EMR", e);
        }
    }

    public List<EMR> getAll() {
        return emrRepository.findAll();
    }

}
