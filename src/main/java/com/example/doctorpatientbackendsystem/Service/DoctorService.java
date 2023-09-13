package com.example.doctorpatientbackendsystem.Service;

import com.example.doctorpatientbackendsystem.Model.Doctor;
import com.example.doctorpatientbackendsystem.Repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        // Implement validation logic (e.g., name, email, phone number)
        // Save the doctor entity to the database
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
