package com.brainiacs.hospitalBackend.reposotory;

import com.brainiacs.hospitalBackend.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
}
