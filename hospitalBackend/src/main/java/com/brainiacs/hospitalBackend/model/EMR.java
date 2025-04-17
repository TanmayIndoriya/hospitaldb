package com.brainiacs.hospitalBackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "emr")
@Data
@Builder
public class EMR {
    @Id
    private String emrId;
    private String patientId;
    private String doctorName;
    private LocalDateTime recordDate;
    private List<String> medications;
    private Map<String,Double> labTests;
    private String notes;
}
