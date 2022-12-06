package com.macnss.model;


import com.macnss.model.embeddable.PrescriptionId;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class Prescription {

    @EmbeddedId
    PrescriptionId id;

    @Column( name = "consultation_date")
    LocalDate consultationDate;

    int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("medicationCodeBarre")
    Medication medication;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("patientFileId")
    PatientFile patientFile;

    public PrescriptionId getId() {
        return id;
    }

    public void setId(PrescriptionId id) {
        this.id = id;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public PatientFile getPatientFile() {
        return patientFile;
    }

    public void setPatientFile(PatientFile patientFile) {
        this.patientFile = patientFile;
    }
}
