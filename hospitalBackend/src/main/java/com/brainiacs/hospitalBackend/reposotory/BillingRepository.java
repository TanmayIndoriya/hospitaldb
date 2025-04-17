package com.brainiacs.hospitalBackend.reposotory;

import com.brainiacs.hospitalBackend.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends MongoRepository<Bill, String> {
    List<Bill> findByPatientId(String patientId);
}
