package com.example.doctorpatientbackendsystem.Controller;

import com.example.doctorpatientbackendsystem.Model.Doctor;
import com.example.doctorpatientbackendsystem.Service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SuggestionController {


    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/doc/suggest")
    public ResponseEntity<List<Doctor>> suggestDoctors(@RequestParam Long patientId) {
        List<Doctor> suggestedDoctors = suggestionService.suggestDoctors(patientId);
        if (suggestedDoctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(suggestedDoctors);
    }
}
