package com.macnss.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type;

    @Column( name = "refund_price")
    double refundPrice;

    boolean refundable;

    @OneToMany(mappedBy = "consultationType", fetch = FetchType.EAGER)
    List<PatientFile> patientFiles;

}
