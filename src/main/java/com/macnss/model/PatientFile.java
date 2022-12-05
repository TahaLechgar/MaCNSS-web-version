package com.macnss.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PatientFile {
    @Id
    int id;

    @Column(nullable = false)
    String state;

    @Column(name = "repayment_amount")
    double repaymentAmount;

    @Column(name = "created_at")
    LocalDate createdAt;

    @Column(name = "deposited_at")
    LocalDate depositedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "patient_matriculate")
    Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "consultation_type")
    Consultation consultationType;

    @OneToMany(mappedBy = "patientFile", fetch = FetchType.EAGER)
    List<Attachement> attachements;

    @OneToMany(mappedBy = "patientFile", fetch = FetchType.EAGER)
    List<Prescription> medications;

    public void addMedication(Medication medication, int quantity) {
        Prescription prescription = new Prescription();
        prescription.setMedication(medication);
        prescription.setPatientFile(this);
        prescription.setQuantity(quantity);
        prescription.setConsultationDate(LocalDate.now());
        medications.add(prescription);
        medication.getPatientFiles().add(prescription);
    }

    // remove medication
    public void removeMedication(Medication medication) {
        for (Prescription prescription : medications) {
            if (prescription.getMedication().equals(medication)) {
                medications.remove(prescription);
                medication.getPatientFiles().remove(prescription);
                prescription.setMedication(null);
                prescription.setPatientFile(null);
            }
        }

    }


    public void addAttachement(Attachement attachement) {
        attachements.add(attachement);
        attachement.setPatientFile(this);
    }



}


