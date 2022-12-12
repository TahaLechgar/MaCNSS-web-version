package com.macnss.model;


import com.macnss.model.embeddable.PrescriptionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prescription {

    @EmbeddedId
    PrescriptionId id = new PrescriptionId();

    @Column( name = "consultation_date")
    LocalDate consultationDate;

    int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("medicationCodeBarre")
    Medication medication;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("patientFileId")
    PatientFile patientFile;

}
