package com.example.doctorpatientbackendsystem.Service;

import com.example.doctorpatientbackendsystem.Model.Doctor;
import com.example.doctorpatientbackendsystem.Model.Patient;
import com.example.doctorpatientbackendsystem.Repository.IDoctorRepository;
import com.example.doctorpatientbackendsystem.Repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class SuggestionService {
    @Autowired
    private IDoctorRepository doctorRepository;

    @Autowired
    private IPatientRepository patientRepository;

    public List<Doctor> suggestDoctors(Long patientId) {
        // Retrieve the patient by ID
        Optional<Patient> patientOptional = patientRepository.findById(patientId);

        if (!patientOptional.isPresent()) {
            // Handle patient not found
            return Collections.emptyList();
        }

        Patient patient = patientOptional.get();
        String patientCity = patient.getCity();
        String patientSymptom = patient.getSymptom();

        // Retrieve doctors with the same city and speciality as the patient's symptom
        List<Doctor> suggestedDoctors = doctorRepository.findByCityAndSpeciality(patientCity, mapSymptomToSpeciality(patientSymptom));

        return suggestedDoctors;
    }

    private String mapSymptomToSpeciality(String symptom) {
        HashMap<String,String > hm=new HashMap<>();
        hm.put("Arthritis","Orthopedic");
        hm.put("Back Pain","Orthopedic");
        hm.put("Tissue injuries","Orthopedic");
        hm.put("Dysmenorrhea","Gynecology");
        hm.put("Skin infection","Dermatology");
        hm.put("Skin burn","Dermatology");
        hm.put("Ear pain","ENT");

        return hm.get(symptom);

    }
}
