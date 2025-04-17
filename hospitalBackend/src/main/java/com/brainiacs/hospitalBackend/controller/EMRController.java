package com.brainiacs.hospitalBackend.controller;

import com.brainiacs.hospitalBackend.model.EMR;
import com.brainiacs.hospitalBackend.service.EMRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emr")
public class EMRController {

    private final EMRService emrService;

    @Autowired
    public EMRController(EMRService emrService) {
        this.emrService = emrService;
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<EMR>> getEMRForPatient(@PathVariable String patientId){
        return ResponseEntity.ok(emrService.getByPatientId(patientId));
    }

    @PostMapping
    public ResponseEntity<EMR> createEMR(@RequestBody EMR emr){
        EMR saved = emrService.save(emr);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<EMR>> getAllEMRs(){
        return ResponseEntity.ok(emrService.getAll());
    }



}
