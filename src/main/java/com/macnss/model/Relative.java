package com.macnss.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Relative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "full_name", nullable = false)
    String fullName;

    @Column(nullable = false)
    String relationship;

    @Column(nullable = false)
    LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patient;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}

