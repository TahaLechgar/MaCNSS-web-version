package com.macnss.model;

import jakarta.persistence.*;

@Entity
public class Attachement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type;

    double price;

    @ManyToOne
    @JoinColumn( name = "patient_file_id")
    PatientFile patientFile;

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PatientFile getPatientFile() {
        return patientFile;
    }

    public void setPatientFile(PatientFile patientFile) {
        this.patientFile = patientFile;
    }
}
