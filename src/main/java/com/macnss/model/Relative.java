package com.macnss.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
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

}

