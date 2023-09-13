package com.example.doctorpatientbackendsystem.Service;

import com.example.doctorpatientbackendsystem.Model.Patient;
import com.example.doctorpatientbackendsystem.Repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private IPatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        // Implement validation logic (e.g., name, email, phone number)
        // Save the patient entity to the database
        return patientRepository.save(patient);
    }

    public void removePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

}
