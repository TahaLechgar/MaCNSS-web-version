package com.macnss.service;

import com.macnss.model.PatientFile;
import com.macnss.repositories.PatientFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientFileService {
    PatientFileRepository patientFileRepository;

    @Autowired
    public PatientFileService(PatientFileRepository patientFileRepository) {
        this.patientFileRepository = patientFileRepository;
    }

    public void savePatientFile(PatientFile patientFile){
        patientFileRepository.save(patientFile);
    }
}
