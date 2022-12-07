package com.macnss.model;

import com.macnss.model.superclasse.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Agent extends User {

    @Id @GeneratedValue(strategy = IDENTITY)
    int id;

    @Column(name = "full_name")
    String fullName;

}
