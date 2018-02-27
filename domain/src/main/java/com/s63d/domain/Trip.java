package com.s63d.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;

@Entity
public class Trip {
    @Id
    @GeneratedValue
    private long Id;

    @OneToMany
    private HashSet<Location> locations;

    public Trip(HashSet<Location> locations) {
        this.locations = locations;
    }

    public HashSet<Location> getLocations() {
        return locations;
    }

    public void setLocations(HashSet<Location> locations) {
        this.locations = locations;
    }
}
