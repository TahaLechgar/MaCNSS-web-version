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
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "code_barre" )
    int codeBarre;

    String name;

    double price;

    @Column( name = "refund_price")
    double refundPrice;

    @OneToMany(mappedBy = "medication")
    List<Prescription> patientFiles;

}
