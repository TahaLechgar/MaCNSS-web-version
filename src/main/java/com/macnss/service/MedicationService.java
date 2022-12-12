package com.macnss.service;

import com.macnss.model.Medication;
import com.macnss.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicationService {

    MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public Medication getMedicationByCodeBarre(int id){
        return medicationRepository.findMedicationByCodeBarre(id);
    }
}

