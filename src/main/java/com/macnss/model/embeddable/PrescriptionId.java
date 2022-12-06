package com.macnss.model.embeddable;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrescriptionId implements Serializable {

    @Column( name = "medication_code_barre" )
    int medicationCodeBarre;

    @Column( name = "patient_file_id" )
    int patientFileId;

    // Constructors
    public PrescriptionId() {}

    public PrescriptionId(int medicationCodeBarre, int patientFileId) {
        this.medicationCodeBarre = medicationCodeBarre;
        this.patientFileId = patientFileId;
    }
    // Getters and setters

    public int getMedicationCodeBarre() {
        return medicationCodeBarre;
    }

    public void setMedicationCodeBarre(int medicationCodeBarre) {
        this.medicationCodeBarre = medicationCodeBarre;
    }

    public int getPatientFileId() {
        return patientFileId;
    }

    public void setPatientFileId(int patientFileId) {
        this.patientFileId = patientFileId;
    }

    // equals && hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrescriptionId that = (PrescriptionId) o;

        if (medicationCodeBarre != that.medicationCodeBarre) return false;
        return patientFileId == that.patientFileId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationCodeBarre, patientFileId);
    }

}
