package com.brainiacs.hospitalBackend.service;

import com.brainiacs.hospitalBackend.exception.ResourceNotFoundException;
import com.brainiacs.hospitalBackend.model.Bill;
import com.brainiacs.hospitalBackend.reposotory.BillingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillingRepository billingRepository;

    public BillService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Bill save(Bill bill) {
        try {
            return billingRepository.save(bill);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save bill", e);
        }
    }

    public Bill get(String billId) {
        return billingRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with ID: " + billId));
    }

    public List<Bill> getAllForPatient(String patientId) {
        try {
            return billingRepository.findByPatientId(patientId);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching bills for patientId: " + patientId, e);
        }
    }
}

