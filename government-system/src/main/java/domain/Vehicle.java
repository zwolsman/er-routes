package domain;

import java.util.HashSet;

public class Vehicle {
    private String licensePlate;
    private String model;
    private Boolean stolen;
    private HashSet<Trip> trips;
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
