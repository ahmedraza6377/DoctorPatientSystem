package com.example.doctorpatientbackendsystem.Controller;

import com.example.doctorpatientbackendsystem.Model.Doctor;
import com.example.doctorpatientbackendsystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/docs/doc")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }
    @DeleteMapping("/docs/{doctorId}")
    public ResponseEntity<String> removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
        return ResponseEntity.ok("Doctor removed successfully");
    }
}
