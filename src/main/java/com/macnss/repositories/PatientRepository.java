package com.macnss.repositories;

import com.macnss.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByMatriculate(int matriculate);
}

