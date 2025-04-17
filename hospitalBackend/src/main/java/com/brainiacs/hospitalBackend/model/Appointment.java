package com.brainiacs.hospitalBackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "appointments")
@Data
@Builder
public class Appointment {
    @Id
    private String appointmentId;
    private String patientId;
    private String doctorName;
    private LocalDateTime appointmentDateTime;
    private String reason;
    private String status;
}
