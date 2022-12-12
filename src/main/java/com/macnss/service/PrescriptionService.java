package com.macnss.service;

import com.macnss.model.Medication;
import com.macnss.model.PatientFile;
import com.macnss.model.Prescription;
import com.macnss.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionService {

    PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription getPrescriptionById(int id){
        return prescriptionRepository.findPrescriptionById(id);
    }

    public void savePrescriptions(List<Medication> medications, PatientFile patientFile){
        for (Medication medication : medications) {
            Prescription prescription = new Prescription();
            prescription.setMedication(medication);
            prescription.setPatientFile(patientFile);
            prescription.setQuantity(1);
            prescriptionRepository.save(prescription);
        }
    }

}
