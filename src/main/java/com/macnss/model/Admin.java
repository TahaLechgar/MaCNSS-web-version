package com.macnss.model;

import com.macnss.model.superclasse.User;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Admin extends User implements Serializable {
    @Id
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
