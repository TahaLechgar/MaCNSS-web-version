package com.macnss.model;

import com.macnss.model.superclasse.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patient extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int matriculate;

    @Column( name = "full_name")
    String fullName;

    @OneToMany(mappedBy = "patient")
    List<Relative> relatives;

}
