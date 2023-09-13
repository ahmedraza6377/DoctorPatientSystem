package com.example.doctorpatientbackendsystem.Controller;

import com.example.doctorpatientbackendsystem.Model.Patient;
import com.example.doctorpatientbackendsystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/patient/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @DeleteMapping("/patient/{patientId}")
    public ResponseEntity<String> removePatient(@PathVariable Long patientId) {
        patientService.removePatient(patientId);
        return ResponseEntity.ok("Patient removed successfully");
    }
}
