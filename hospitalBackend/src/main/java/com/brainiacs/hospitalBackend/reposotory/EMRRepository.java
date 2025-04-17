package com.brainiacs.hospitalBackend.reposotory;

import com.brainiacs.hospitalBackend.model.EMR;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EMRRepository extends MongoRepository<EMR, String> {
    List<EMR> findByPatientId(String patientId);
}
