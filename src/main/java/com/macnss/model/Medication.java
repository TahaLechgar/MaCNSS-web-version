package com.macnss.model;

import javax.persistence.*;

import java.util.List;

@Entity
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


    // getters & setters

    public int getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(int codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(double refundPrice) {
        this.refundPrice = refundPrice;
    }

    public List<Prescription> getPatientFiles() {
        return patientFiles;
    }

    public void setPatientFiles(List<Prescription> patientFiles) {
        this.patientFiles = patientFiles;
    }
}
