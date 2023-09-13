package com.example.doctorpatientbackendsystem.Repository;

import com.example.doctorpatientbackendsystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long> {

}
