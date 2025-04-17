package com.brainiacs.hospitalBackend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
@Data
@Builder
public class Patient {
    @Id
    private String patientId;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private String contactNumber;
    private String email;
    private String address;
    private String medicalHistory;

}
