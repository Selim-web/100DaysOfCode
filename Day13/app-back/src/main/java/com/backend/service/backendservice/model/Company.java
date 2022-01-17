package com.backend.service.backendservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String location;
    private int nbbuilding;

    public Company(Integer id, String name, String location, int nbbuilding) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.nbbuilding = nbbuilding;
    }

    public Company() {}

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getnbbuilding() {
        return nbbuilding;
    }

    public void setnbbuilding(int nbbuilding) {
        this.nbbuilding = nbbuilding;
    }
}
