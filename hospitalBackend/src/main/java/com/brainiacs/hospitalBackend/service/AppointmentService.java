package com.brainiacs.hospitalBackend.service;

import com.brainiacs.hospitalBackend.exception.ResourceNotFoundException;
import com.brainiacs.hospitalBackend.model.Appointment;
import com.brainiacs.hospitalBackend.reposotory.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment save(Appointment appointment) {
        try {
            return appointmentRepository.save(appointment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save appointment", e);
        }
    }

    public Appointment get(String appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));
    }

    public List<Appointment> getPatientAppointments(String patientId) {
        try {
            return appointmentRepository.findByPatientId(patientId);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching appointments for patientId: " + patientId, e);
        }
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public void delete(String appointmentId) {
        if (!appointmentRepository.existsById(appointmentId)) {
            throw new ResourceNotFoundException("Cannot delete. Appointment not found with ID: " + appointmentId);
        }
        appointmentRepository.deleteById(appointmentId);
    }
}

