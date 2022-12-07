package com.macnss.model;

import com.macnss.model.superclasse.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin extends User implements Serializable {
    @Id @GeneratedValue(strategy = IDENTITY)
    int id;

}
