package com.example.doctorpatientbackendsystem.Repository;

import com.example.doctorpatientbackendsystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Long> {

    List<Doctor> findByCityAndSpeciality(String patientCity, String s);
}
