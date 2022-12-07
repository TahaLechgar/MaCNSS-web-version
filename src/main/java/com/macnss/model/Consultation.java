package com.macnss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String type;

    @Column( name = "refund_price")
    double refundPrice;

    boolean refundable;

    @OneToMany(mappedBy = "consultationType")
    List<PatientFile> patientFiles;

}
