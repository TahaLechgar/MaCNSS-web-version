package com.macnss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attachement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type;

    double price;

    @ManyToOne
    @JoinColumn( name = "patient_file_id")
    PatientFile patientFile;

}
