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
    private CarTracker carTracker;

    public Vehicle(String licensePlate, String model, Boolean stolen, HashSet<Trip> trips, CarTracker carTracker) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.stolen = stolen;
        this.trips = trips;
        this.carTracker = carTracker;
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

    public CarTracker getCartracker() {
        return carTracker;
    }

    public void setCartracker(CarTracker carTracker) {
        this.carTracker = carTracker;
    }
}
