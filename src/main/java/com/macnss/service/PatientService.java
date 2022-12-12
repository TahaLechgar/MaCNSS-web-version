package com.macnss.service;

import com.macnss.model.Patient;
import com.macnss.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientService {

    PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientByMatriculate(int id){
        return patientRepository.findPatientByMatriculate(id);
    }

}
