package com.macnss.model;

import com.macnss.model.superclasse.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int matriculate;

    @Column( name = "full_name")
    String fullName;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    List<Relative> relatives;


    public int getId() {
        return matriculate;
    }

    public void setId(int matriculate) {
        this.matriculate = Patient.this.matriculate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
