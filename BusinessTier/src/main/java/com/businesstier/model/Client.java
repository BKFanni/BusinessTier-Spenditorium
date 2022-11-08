package com.businesstier.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "clients")
public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        // You could also assign table column names
        @Column(name = "Name")
        private String name;
        @Column(name = "DOB")
        private Date dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
