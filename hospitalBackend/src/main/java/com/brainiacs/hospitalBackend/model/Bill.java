package com.brainiacs.hospitalBackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "billing")
@Data
@Builder
public class Bill {
    @Id
    private String billId;
    private String patientId;
    private String appointmentId;
    private LocalDateTime billingDate;
    private Map<String, Double> items;
    private Double totalAmount;
    private String paymentStatus;

}
