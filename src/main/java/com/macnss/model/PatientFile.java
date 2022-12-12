package com.macnss.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientFile {
    @Id
    @GeneratedValue(strategy = IDENTITY)
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

    @OneToMany(mappedBy = "patientFile")
    List<Attachment> attachments;

    @OneToMany(mappedBy = "patientFile")
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


    public void addAttachement(Attachment attachment) {
        attachments.add(attachment);
        attachment.setPatientFile(this);
    }



}


