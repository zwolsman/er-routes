package com.s63d.domain;

import javax.persistence.*;
import java.util.HashSet;

@Entity
public class Vehicle {
    @Id @GeneratedValue
    private long Id;

    @Column(unique = true)
    private String licensePlate;
    @Column(unique = true)
    private String model;

    private Boolean stolen;
    @OneToMany
    private HashSet<Trip> trips;

    @OneToOne
    private Cartracker cartracker;

    public Vehicle(String licensePlate, String model, Boolean stolen, HashSet<Trip> trips, Cartracker cartracker) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.stolen = stolen;
        this.trips = trips;
        this.cartracker = cartracker;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getStolen() {
        return stolen;
    }

    public void setStolen(Boolean stolen) {
        this.stolen = stolen;
    }

    public HashSet<Trip> getTrips() {
        return trips;
    }

    public void setTrips(HashSet<Trip> trips) {
        this.trips = trips;
    }

    public Cartracker getCartracker() {
        return cartracker;
    }

    public void setCartracker(Cartracker cartracker) {
        this.cartracker = cartracker;
    }
}
