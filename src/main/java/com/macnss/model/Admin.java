package com.macnss.model;

import com.macnss.model.superclasse.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin extends User {
    @Id
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
