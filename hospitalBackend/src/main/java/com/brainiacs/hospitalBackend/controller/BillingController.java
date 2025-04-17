package com.brainiacs.hospitalBackend.controller;

import com.brainiacs.hospitalBackend.model.Bill;
import com.brainiacs.hospitalBackend.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/billing")
public class BillingController {

    private final BillService billingService;

    @Autowired
    public BillingController(BillService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBill(@PathVariable String billId){
        return ResponseEntity.ok(billingService.get(billId));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<Bill>> getPatientBills(@PathVariable String patientId){
        return ResponseEntity.ok(billingService.getAllForPatient(patientId));
    }

}
